package exercise.controller;

import io.javalin.http.Context;
import exercise.repository.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.Base64;
import java.util.Optional;

public class AuthController {
    // BEGIN (write your solution here)
    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    public static void basicAuthMiddleware(Context ctx) throws SQLException {
        String authHeader = ctx.header("Authorization");
        logger.debug("Processing authentication for request to: {}", ctx.path());

        if (authHeader == null || !authHeader.startsWith("Basic ")) {
            logger.warn("Authorization header is missing or invalid");
            ctx.header("WWW-Authenticate", "Basic realm=\"Access to protected area\"");
            ctx.status(401);
            ctx.result("Unauthorized");
            ctx.skipRemainingHandlers();
            return;
        }

        String base64Credentials = authHeader.substring("Basic ".length());
        logger.debug("Received Base64 credentials: {}", base64Credentials);
        try {
            String credentials = new String(Base64.getDecoder().decode(base64Credentials));
            String[] values = credentials.split(":", 2);
            logger.debug("Decoded credentials: {}", credentials);

            if (values.length != 2) {
                logger.warn("Invalid credentials format - expected 'username:password'");
                ctx.header("WWW-Authenticate", "Basic realm=\"Access to protected area\"");
                ctx.status(401);
                ctx.result("Unauthorized");
                ctx.skipRemainingHandlers();
                return;
            }
            String username = values[0];
            String password = values[1];
            logger.info("Attempting authentication for user: {}", username);

            var userOpt = UsersRepository.findByName(username);

            if (userOpt.isEmpty() || !userOpt.get().getPassword().equals(password)) {
                logger.warn("Authentication failed for user: {}", username);
                ctx.header("WWW-Authenticate", "Basic realm=\"Access to protected area\"");
                ctx.status(401);
                ctx.result("Unauthorized");
                ctx.skipRemainingHandlers();
                return;
            }

            logger.info("User authenticated successfully: {}", username);
        } catch (IllegalArgumentException e) {
            logger.error("Error decoding Base64 credentials", e);
            ctx.header("WWW-Authenticate", "Basic realm=\"Access to protected area\"");
            ctx.status(401);
            ctx.result("Unauthorized");
            ctx.skipRemainingHandlers();
        }
    }
    // END
}
