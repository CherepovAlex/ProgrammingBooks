package io.hexlet.dto.users;

import io.hexlet.dto.BasePage;
import io.hexlet.model.User;

import lombok.Getter;

import java.util.List;

@Getter
public class UsersPage extends BasePage {
    private List<User> users;
    String flash;
    private String currentUser;

    public UsersPage(List<User> users, String flash, String currentUser) {
        this.users = users;
        this.flash = flash;
        this.currentUser = currentUser;
    }

}
