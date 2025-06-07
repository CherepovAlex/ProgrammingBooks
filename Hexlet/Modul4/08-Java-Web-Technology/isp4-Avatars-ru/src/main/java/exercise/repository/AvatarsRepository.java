package exercise.repository;

import exercise.model.Avatar;

import java.sql.SQLException;
import java.util.Optional;

public class AvatarsRepository extends BaseRepository {
    public static Optional<Avatar> findByUserId(Long userId) throws SQLException {
        var sql = "SELECT * FROM avatars WHERE id = ?";

        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, userId);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var url = resultSet.getString("url");
                var avatar = new Avatar(url);

                return Optional.of(avatar);
            }
            return Optional.empty();
        }
    }
}
