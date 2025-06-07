package io.hexlet.dto.articles;

import io.hexlet.model.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ArticlesPage {
    private List<Article> articles;
}
