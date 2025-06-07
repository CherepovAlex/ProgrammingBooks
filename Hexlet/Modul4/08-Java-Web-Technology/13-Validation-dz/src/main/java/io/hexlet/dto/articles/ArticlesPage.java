package io.hexlet.dto.articles;

import java.util.List;
import io.hexlet.model.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ArticlesPage {
    private List<Article> articles;
}
