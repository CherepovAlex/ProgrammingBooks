package io.hexlet.dto.users;

import io.hexlet.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public final class UsersPage {
    private List<User> users;
}
// END