package io.hexlet.dto.users;

import io.hexlet.model.User;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN (write your solution here)
@AllArgsConstructor
@Getter
public class UsersPage {
    private List<User> users;
    private String header;
}
// END
