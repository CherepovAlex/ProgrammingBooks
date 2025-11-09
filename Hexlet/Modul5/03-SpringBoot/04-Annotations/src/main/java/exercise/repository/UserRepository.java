package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import exercise.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(Object email);
}