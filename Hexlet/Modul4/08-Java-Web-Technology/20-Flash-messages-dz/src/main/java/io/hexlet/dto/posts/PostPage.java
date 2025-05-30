package io.hexlet.dto.posts;

import io.hexlet.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostPage {
    private Post post;
}
