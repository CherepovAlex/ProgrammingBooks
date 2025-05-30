package io.hexlet;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import io.hexlet.controller.CarController;
import io.hexlet.repository.BaseRepository;

import io.hexlet.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinJte;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class App {

    public static Javalin getApp() throws Exception{
        // создаём объект для хранения конфигурации для пула соединений HikariCP
        var hikariConfig = new HikariConfig();
        // установка url для подключения к БД H2 с названием "hexlet_project" в памяти (in-memory)
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet_project;DB_CLOSE_DELAY=-1;");
        // создание пула соединений по заданной ранее конфигурации
        var dataSource = new HikariDataSource(hikariConfig);
        // получаем путь до файла в src/main/resources
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        // читает SQL-скрипт из файла и объединяет его в одну строку.
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));
        // Получаем соединение из пула
        try (var connection = dataSource.getConnection();
        // создаём стейтмент (SQL-запрос)
                var statement = connection.createStatement()) {
        // и выполняем запрос - создаёт таблицы из файла schema.sql
            statement.execute(sql);
        }
        // присваивание пула соединений статическому полю в базовом классе
        // для доступа наследующим репозиториям
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
           config.bundledPlugins.enableDevLogging();
           config.fileRenderer(new JavalinJte());
        });
        app.get(NamedRoutes.rootPath(), CarController::index);

        app.get(NamedRoutes.buildCarPath(), CarController::build);
        app.post(NamedRoutes.carsPath(), CarController::create);

        app.get(NamedRoutes.carsPath(), CarController::index);
        app.get(NamedRoutes.carPath("{id}"), CarController::show);
        return app;
    }

    public static void main(String[] args) throws Exception {
        Javalin app = getApp();
        app.start(7070);
    }
}
