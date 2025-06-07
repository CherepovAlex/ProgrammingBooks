package exercise.repository;

import exercise.model.Avatar;
import exercise.model.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class UsersRepository extends BaseRepository {

    // BEGIN (write your solution here)

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT u.id AS user_id, u.name AS user_name, u.email AS user_email, "
                + "a.id AS avatar_id, a.url AS avatar_url "
                + "FROM users u LEFT JOIN avatars a ON u.avatar_id = a.id "
                + "WHERE u.id = ?";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var userName = resultSet.getString("user_name");
                var userEmail = resultSet.getString("user_email");
                var avatarUrl = resultSet.getString("avatar_url");
                var avatarId = resultSet.getLong("avatar_id");

                var avatar = new Avatar(avatarUrl);
                avatar.setId(avatarId);
                var user = new User(userName, userEmail);
                user.setId(id);
                user.addAvatar(avatar);

                return Optional.of(user);
            }
            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            var resultSet = stmt.executeQuery();
            var result = new ArrayList<User>();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");

                var user = new User(name, email);
                user.setId(id);
                result.add(user);
            }
            return result;
        }
    }
    // END
}
