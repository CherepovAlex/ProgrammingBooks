package exercise.controller;

import io.javalin.http.Context;
import java.sql.SQLException;

public class ProtectedController {
    public static void index(Context ctx) throws SQLException {
        ctx.result("Welcome to protected Area");
    }
}