package io.hexlet.dto.users;

import io.hexlet.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN (write your solution here)
@AllArgsConstructor
@Getter
public class UserPage {
    private User user;
}
// END
