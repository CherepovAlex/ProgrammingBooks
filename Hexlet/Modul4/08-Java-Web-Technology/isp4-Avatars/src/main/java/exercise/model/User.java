package exercise.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class User {
    @Setter
    private long id;
    private String name;
    private String email;
    private Avatar avatar;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void addAvatar(Avatar usersAvatar) {
        this.avatar = usersAvatar;
        avatar.setOwner(this);
    }
}
