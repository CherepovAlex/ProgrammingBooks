package io.hexlet.dto.users;

import io.hexlet.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserPage {
    private User user;
}
