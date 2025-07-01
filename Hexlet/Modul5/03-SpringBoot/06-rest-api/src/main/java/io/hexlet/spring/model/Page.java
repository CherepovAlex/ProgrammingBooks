package io.hexlet.spring.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@Setter
public class Page {
    // Используется как идентификатор в ссылках /pages/about
    // Здесь слаг - это идентификатор для построения ссылок
    private String id; // слаг
    private String name; // имя страницы
    private String body; // содержимое страницы
}
