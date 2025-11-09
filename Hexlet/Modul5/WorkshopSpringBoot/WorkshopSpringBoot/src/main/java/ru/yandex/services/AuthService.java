package ru.yandex.services;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public Long validateTokenAndGetUserId(String token) {
        // Реализация проверки токена
        // Например, JWT валидация или проверка в БД
        // В реальном приложении здесь будет сложная логика

        if (token == null || !token.startsWith("Bearer ")) {
            throw new SecurityException("Invalid token");
        }

        // Пример простой реализации (заменить на реальную)
        try {
            String cleanToken = token.substring(7);
            // Декодирование токена и извлечение userId
            return Long.parseLong(cleanToken); // упрощенный пример
        } catch (Exception e) {
            throw new SecurityException("Invalid token format");
        }
    }
}