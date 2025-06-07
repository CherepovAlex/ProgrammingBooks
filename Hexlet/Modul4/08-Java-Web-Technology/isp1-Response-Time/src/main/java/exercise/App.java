package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.sql.SQLException;

import java.util.stream.Collectors;

import exercise.controller.ProductsController;
import exercise.controller.RootController;
import exercise.util.NamedRoutes;
import exercise.repository.BaseRepository;

import io.javalin.Javalin;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


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
        });

        // BEGIN (write your solution here)
        // выполняется перед каждым запросом и сохраняет текущую метку времени в атрибутах контекста
        app.before(ctx -> {
        // Использует для сохранения текущего времени в миллисекундах в контексте
            ctx.attribute("startTime", System.currentTimeMillis());
        });
        // END

        app.get(NamedRoutes.rootPath(), RootController::index);
        app.get(NamedRoutes.productsPath(), ProductsController::index);
        app.get(NamedRoutes.productPath("{id}"), ProductsController::show);

        // BEGIN (write your solution here)
        // выполняется после каждого запроса, вычисляет время обработки и устанавливает его в заголовок ответа
        app.after(ctx -> {
            // Получает время начала с помощью
            long startTime = ctx.attribute("startTime");
            // Вычисляет время обработки, вычитая время начала из текущего времени
            long processingTime = System.currentTimeMillis() - startTime;
            // Устанавливает заголовок X-Processing-Time с вычисленным значением
            ctx.header("X-Processing-Time", String.valueOf(processingTime));
        });
        // END

        return app;
    }

    public static void main(String[] args) throws IOException, SQLException {
        Javalin app = getApp();
        app.start("0.0.0.0", 8080);
    }
}
