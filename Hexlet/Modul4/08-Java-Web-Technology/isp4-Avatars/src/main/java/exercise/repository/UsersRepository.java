package exercise.repository;

import exercise.model.Avatar;
import exercise.model.User;

import java.util.List;
import java.util.ArrayList;

import java.sql.SQLException;
import java.util.Optional;


public class UsersRepository extends exercise.repository.BaseRepository {

    // BEGIN (write your solution here)

    public static List<User> getEntities() throws SQLException {
        var sql = "SELECT * FROM users";
        var users = new ArrayList<User>();

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {

            var resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                var id = resultSet.getLong("id");
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var avatarId = resultSet.getLong("avatar_id");

                var user = new User(name, email);
                user.setId(id);

                if (!resultSet.wasNull()) {
                    var avatar = AvatarsRepository.findByUserId(avatarId).orElse(null);
                    if (avatar != null) {
                        avatar.setId(avatarId);
                        user.addAvatar(avatar);
                    }
                }
                users.add(user);
            }
        }
        return users;
    }

    public static Optional<User> find(Long id) throws SQLException {
        var sql = "SELECT * FROM users WHERE id = ?";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                var name = resultSet.getString("name");
                var email = resultSet.getString("email");
                var avatarId = resultSet.getLong("avatar_id");

                var user = new User(name, email);
                user.setId(id);

                if (!resultSet.wasNull()) {
                    var avatar = AvatarsRepository.findByUserId(avatarId).orElse(null);
                    if (avatar != null) {
                        avatar.setId(avatarId);
                        user.addAvatar(avatar);
                    }
                }
                return Optional.of(user);
            }
            return Optional.empty();
        }
    }
    // END
}
