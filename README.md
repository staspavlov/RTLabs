# Тестовое задание

## База данных

Инструкции для создания БД и пользователя находятся в файле `db_install.js`.

Инструкции для наполнения БД тестовыми данными находятся в файле `db_test_data.js`.

## Настройка и сборка

Необходимо прописать актуальные параметры подключения к БД в файле `src/main/resources/config/Database.properties`.

Для компиляции и сборки JAR-архива можно воспользоваться следующей командой:

```
mvn clean compile package
```

## Запуск

Для запуска приложения можно воспользоваться командой:

```
java -jar target\RTLabs-1.0-SNAPSHOT.jar
```
