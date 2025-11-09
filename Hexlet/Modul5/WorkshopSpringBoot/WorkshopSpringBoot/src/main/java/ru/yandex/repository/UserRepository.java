package ru.yandex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yandex.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(Object email);
}