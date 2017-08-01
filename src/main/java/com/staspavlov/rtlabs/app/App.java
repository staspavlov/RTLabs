package com.staspavlov.rtlabs.app;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Главный класс приложения
 */
public class App extends Application {

    /**
     * Контекст Spring
     */
    private AnnotationConfigApplicationContext ctx;

    /**
     * Инициализация приложения
     *
     * @throws Exception
     */
    @Override
    public void init() throws Exception {
        super.init();

        // Создаем контекст Spring
        ctx = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    /**
     * Старт приложения
     *
     * @param stage Главное окно приложения
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        // Создаем загрузчик и добавляем фабрику контроллеров
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/App.fxml"));
        loader.setControllerFactory(ctx::getBean);
        Parent root = loader.load();

        // Отображаем окно
        Scene scene = new Scene(root, 1100, 700);
        stage.setTitle("Тестовое задание");
        stage.setMinWidth(800);
        stage.setMinHeight(600);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Завершение приложения
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        // Закрываем контекст Spring
        if (ctx != null) {
            ctx.close();
        }

        super.stop();
    }

    /**
     * Точка входа в приложение
     *
     * @param args Агрументы запуска
     */
    public static void main(String[] args) {
        launch(args);
    }

}
