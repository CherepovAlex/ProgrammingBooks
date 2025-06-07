package io.hexlet;

import lombok.Getter;
import java.io.IOException;

// BEGIN (write your solution here)
@Getter
public class AppConfig {

    public static String getUrl() {
        try {
            return FileUtils.getConfigData("db.url");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.url", e);
        }
    }

    public static String getUsername() {
        try {
            return FileUtils.getConfigData("db.username");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.username", e);
        }
    }

    public static String getPassword() {
        try {
            return FileUtils.getConfigData("db.password");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load db.password", e);
        }
    }

    public static void main(String[] args) throws IOException{

        System.out.println(getUrl());
    }
}
// END