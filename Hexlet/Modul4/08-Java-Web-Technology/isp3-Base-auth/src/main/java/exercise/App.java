package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;

import java.util.stream.Collectors;

import exercise.controller.AuthController;
import exercise.controller.ProtectedController;
import exercise.controller.RootController;
import exercise.util.NamedRoutes;
import exercise.repository.BaseRepository;

import io.javalin.Javalin;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.javalin.rendering.template.JavalinThymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class App {

    private static final Logger logger = LoggerFactory.getLogger(App.class);

    public static Javalin getApp() throws IOException, SQLException {
        logger.info("Starting application initialization");

        var hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl("jdbc:h2:mem:hexlet;DB_CLOSE_DELAY=-1;");
        logger.debug("Configured HikariCP with URL: {}", hikariConfig.getJdbcUrl());

        var dataSource = new HikariDataSource(hikariConfig);
        var url = App.class.getClassLoader().getResourceAsStream("schema.sql");
        var sql = new BufferedReader(new InputStreamReader(url))
                .lines().collect(Collectors.joining("\n"));

        logger.debug("Executing database schema initialization");
        try (var connection = dataSource.getConnection();
             var statement = connection.createStatement()) {
            statement.execute(sql);
        }
        BaseRepository.dataSource = dataSource;

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinThymeleaf());
            logger.debug("Javalin configured with Thymeleaf");
        });
        // BEGIN (write your solution here)
        app.before(NamedRoutes.protectedPath(), AuthController::basicAuthMiddleware);
        logger.debug("Protected route configured: {}", NamedRoutes.protectedPath());
        app.post(NamedRoutes.protectedPath(), ProtectedController::index);
        // END
        app.get(NamedRoutes.rootPath(), RootController::index);
        app.get(NamedRoutes.protectedPath(), ProtectedController::index);

        logger.info("Application initialization completed");
        return app;
    }

    public static void main(String[] args) throws IOException, SQLException {
        logger.info("Starting application");
        Javalin app = getApp();
        app.start(8080);
        logger.info("Application started on port 8080");
    }
}
