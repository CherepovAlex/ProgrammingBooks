package io.hexlet.dto.users;

import io.hexlet.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

// BEGIN
@AllArgsConstructor
@Getter
public final class UsersPage {
    private List<User> users;
}
// END