package com.staspavlov.rtlabs.app;

import com.mongodb.Mongo;
import com.staspavlov.rtlabs.controller.AppController;
import java.net.UnknownHostException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Конфигурация Spring
 */
@Configuration
@PropertySource("classpath:config/Database.properties")
@ComponentScan("com.staspavlov.rtlabs")
public class AppConfig {

    /**
     * Доступ к переменным окружения и значениям из properties
     */
    @Autowired
    private Environment env;

    /**
     * Создаем FXML контроллер
     *
     * @return Контроллер
     */
    @Bean
    @Scope("prototype")
    public AppController appController() {
        return new AppController();
    }

    /**
     * Создаем хелпер для MongoDB
     *
     * @return Хелпер для MongoDB
     * @throws UnknownHostException
     */
    @Bean
    public MongoOperations mongoOperations() throws UnknownHostException {
        String host = env.getProperty("mongo.host");
        int port = Integer.valueOf(env.getProperty("mongo.port"));
        String database = env.getProperty("mongo.database");
        String user = env.getProperty("mongo.username");
        String pass = env.getProperty("mongo.password");

        Mongo mongo = new Mongo(host, port);
        UserCredentials credentials = new UserCredentials(user, pass);

        return (MongoOperations) new MongoTemplate(mongo, database, credentials);
    }
}
