package io.hexlet;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AppTest {

    @Test
    public void testConfiguration() {
        var expectedUrl = "jdbc:h2:mem:test";
        var expectedUser = "test";
        var expectedPass = "password";
        assertEquals(expectedUrl, AppConfig.getUrl());
        assertEquals(expectedPass, AppConfig.getPassword());
        assertEquals(expectedUser, AppConfig.getUsername());
    }
}
