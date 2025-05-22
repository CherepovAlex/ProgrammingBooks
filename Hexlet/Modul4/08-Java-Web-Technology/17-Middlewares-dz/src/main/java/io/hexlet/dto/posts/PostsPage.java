package io.hexlet.dto.posts;

import java.util.List;
import io.hexlet.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostsPage {
    private List<Post> posts;
}
