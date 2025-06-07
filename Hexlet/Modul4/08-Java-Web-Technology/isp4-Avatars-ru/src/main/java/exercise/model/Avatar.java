package exercise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Avatar {
    @Setter
    private long id;
    private String imageUrl;
    @Setter
    private User owner;

    public Avatar(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
