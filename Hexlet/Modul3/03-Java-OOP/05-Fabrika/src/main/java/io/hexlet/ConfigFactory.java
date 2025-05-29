package io.hexlet;

import io.hexlet.parsers.JsonParser;
import io.hexlet.parsers.Parser;
import io.hexlet.parsers.YamlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Objects;

public class ConfigFactory {
    // BEGIN (write your solution here)
    public static AppConfig build(String path) throws Exception {
        String content = Files.readString(Paths.get(path));
        Parser parser;

        if (path.endsWith(".json")) {
            parser = new JsonParser();
        } else if (path.endsWith(".yaml") || path.endsWith(".yml")) {
            parser = new YamlParser();
        } else {
            throw new IllegalArgumentException("Incorrect format");
        }

        Map<String, Object> newContent = parser.parse(content);
        return new AppConfig(newContent);
    }
    // END
}
