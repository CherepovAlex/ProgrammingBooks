package exercise;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import exercise.controller.AuthController;
import exercise.controller.ProtectedController;
import exercise.controller.RootController;
import exercise.repository.BaseRepository;
import exercise.util.NamedRoutes;
import io.javalin.Javalin;
import io.javalin.rendering.template.JavalinThymeleaf;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.stream.Collectors;

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
        });
        // BEGIN (write your solution here)
        app.before(NamedRoutes.protectedPath(), AuthController::basicAuth);
        // END
        app.get(NamedRoutes.rootPath(), RootController::index);
        app.get(NamedRoutes.protectedPath(), ProtectedController::index);

        return app;
    }

    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start(8080);
    }
}
