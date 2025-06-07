package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;

import java.util.stream.Collectors;

import exercise.controller.RootController;
import exercise.controller.UsersController;
import exercise.repository.UsersRepository;
import exercise.util.NamedRoutes;
import exercise.repository.BaseRepository;

import io.javalin.Javalin;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.rendering.template.JavalinThymeleaf;


public final class App {

    public static Javalin getApp() throws IOException, SQLException {

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet;DB_CLOSE_DELAY=-1;");

        var dataSource = new HikariDataSource(hikariConfig);
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
            .lines().collect(Collectors.joining("\n"));

        try (var connection = dataSource.getConnection();
                var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinThymeleaf());
            config.staticFiles.add("/static");
        });

        app.get(NamedRoutes.rootPath(), RootController::index);
        // BEGIN (write your solution here)
        app.get(NamedRoutes.usersPath(), UsersController::index);
        app.get(NamedRoutes.userPath("{id}"), UsersController::show);
        // END

        return app;
    }

    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start(8080);
    }
}
