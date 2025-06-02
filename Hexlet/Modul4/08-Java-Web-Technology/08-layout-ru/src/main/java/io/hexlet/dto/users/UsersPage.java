package io.hexlet.dto.users;

import io.hexlet.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UsersPage {
    private List<User> users;
}
