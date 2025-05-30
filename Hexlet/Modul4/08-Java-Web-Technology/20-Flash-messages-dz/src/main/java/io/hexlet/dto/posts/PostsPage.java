package io.hexlet.dto.posts;

import java.util.List;
import io.hexlet.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import io.hexlet.dto.BasePage;

// BEGIN (write your solution here)
@AllArgsConstructor
@Getter
public class PostsPage extends BasePage {
    private List<Post> posts;
    private String flash;
}
// END
