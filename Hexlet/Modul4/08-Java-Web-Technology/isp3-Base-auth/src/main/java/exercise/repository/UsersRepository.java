package exercise.repository;

import exercise.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsersRepository extends BaseRepository {

    // BEGIN (write your solution here)
private static final Logger logger = LoggerFactory.getLogger(UsersRepository.class);

    public static Optional<User> findByName(String name) throws SQLException {
        logger.debug("Searching for user in database: {}", name);
        var sql = "SELECT * FROM users WHERE name = ?";

        try (var connection = dataSource.getConnection();
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, name);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    var user = new User(
                        rs.getString("name"),
                        rs.getString("password")
                    );
                    user.setId(rs.getLong("id"));
                    logger.debug("Found user: {}", user);
                    return Optional.of(user);
                }
                logger.debug("User not found: {}", name);
                return Optional.empty();
            }
        } catch (SQLException e) {
            logger.error("Database error while searching for user: {}", name, e);
            throw e;
        }
    }
    // END
}
