package ru.yandex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.yandex.dto.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // Можно добавить кастомные методы при необходимости
    // List<Task> findByAuthorId(Long authorId);
}