package io.hexlet.repository;

import io.hexlet.model.Article;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArticleRepository {
    private static List<Article> entities = new ArrayList<Article>();

    public static void save(Article article) {
        article.setId((long) entities.size() + 1);
        entities.add(article);
    }

    public static List<Article> search(String term) {
        return entities.stream()
                .filter(entity -> entity.getTitle().startsWith(term))
                .toList();
    }

    public static Optional<Article> find(Long id) {
        return entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny();
    }

    public static Optional<Article> findByTitle(String title) {
        return entities.stream()
                .filter(entity -> entity.getTitle().equals(title))
                .findAny();
    }

    public static boolean existsByTitle(String title) {
        return entities.stream()
                .anyMatch(value -> value.getTitle().equals(title));
    }

    public static List<Article> getEntities() {
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
