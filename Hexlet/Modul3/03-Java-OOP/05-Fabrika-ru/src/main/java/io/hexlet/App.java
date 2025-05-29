package io.hexlet;

public class App {
    public static void main(String[] args) throws Exception {
        AppConfig config = ConfigFactory.build("resources/fixtures/test.yml");
        config.get("key"); // value
    }
}