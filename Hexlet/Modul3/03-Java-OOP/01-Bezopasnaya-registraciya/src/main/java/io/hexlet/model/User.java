package io.hexlet.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@AllArgsConstructor
public class User {
    @EqualsAndHashCode.Include
    private String email;
    private String password;
}
