package exercise.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public final class User {
    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private Long id;

    private String name;

    private String password;
}
