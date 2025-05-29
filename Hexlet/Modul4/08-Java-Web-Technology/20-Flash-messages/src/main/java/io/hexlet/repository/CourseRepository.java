package io.hexlet.repository;

import io.javalin.http.NotFoundResponse;
import io.hexlet.model.Course;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CourseRepository {
    private static List<Course> entities = new ArrayList<Course>();

    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        course.setCreatedAt(LocalDateTime.now());
        entities.add(course);
    }

    public static List<Course> search(String term) {
        var courses = entities.stream()
                .filter(course -> course.getName().startsWith(term))
                .toList();
        return courses;
    }

    public static Course find(Long id) {
        var courses = entities.stream()
                .filter(course -> course.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NotFoundResponse("Курс не найден"));
        return courses;
    }

    public static boolean existsByTitle(String name) {
        return entities.stream()
                .anyMatch(value -> value.getName().equals(name));
    }

    public static List<Course> findAll() {
        return entities;
    }

    public static void delete(Long id) {
        entities.removeIf(course -> course.getId().equals(id));
    }

    public static void removeAll() {
        entities = new ArrayList<Course>();
    }

    public static List<Course> getEntities() {
        return entities != null ? new ArrayList<>(entities) : Collections.emptyList();
    }
}