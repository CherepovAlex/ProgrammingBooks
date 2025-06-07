package exercise.controller;

import exercise.repository.UsersRepository;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Base64;

public class AuthController {
    // BEGIN (write your solution here)
    public static void basicAuth(Context ctx) throws SQLException {
        var authHeader = ctx.header("Authorization");

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            ctx.status(401)
                    .header("WWW-Authenticate", "Basic realm=\"Access to the protected resource\"")
                    .result("Unauthorized");
            ctx.skipRemainingHandlers();
            return;
        }

        var encoded = authHeader.split(" ")[1];
        var credentials = new String(Base64.getDecoder().decode(encoded));
        var values = credentials.split(":", 2);

        var username = values[0];
        var password = values[1];

        var user = UsersRepository.find(username)
                .orElse(null);

        if (user == null || !user.getPassword().equals(password)) {
            ctx.status(401)
                    .header("WWW-Authenticate", "Basic realm=\"Access to the protected resource\"")
                    .result("Unauthorized");
            ctx.skipRemainingHandlers();
        }
    }
    // END
}
