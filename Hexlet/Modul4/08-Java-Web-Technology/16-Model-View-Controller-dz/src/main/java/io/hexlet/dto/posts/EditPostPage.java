package io.hexlet.dto.posts;

import java.util.List;
import java.util.Map;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

// BEGIN (write your solution here)
import io.hexlet.model.Post;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EditPostPage {
    private Post post;
    private Map<String, List<ValidationError<Object>>> errors;

    public String getName() {
        return post != null ? post.getName() : "";
    }

    public String getBody() {
        return post != null ? post.getBody() : "";
    }

    public Long getId() {
        return post.getId();
    }
}
// END
