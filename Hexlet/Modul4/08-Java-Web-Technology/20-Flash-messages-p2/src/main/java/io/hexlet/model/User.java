package io.hexlet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public final class User {

    private Long id;
    private String name;

    @ToString.Include
    private String lastName;

    private String email;
    private String encriptedPassword;
    private String token;
    private LocalDateTime createdAt;

    public User(Long id, String name, String encriptedPassword) {
        this.id = id;
        this.name = name;
        this.encriptedPassword = encriptedPassword;
        this.createdAt = LocalDateTime.now();
    }

    public User(String name, String lastName, String email, String encriptedPassword, String token) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.encriptedPassword = encriptedPassword;
        this.token = token;
    }
}
