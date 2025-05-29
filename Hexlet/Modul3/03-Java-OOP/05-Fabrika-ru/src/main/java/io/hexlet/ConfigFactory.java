package io.hexlet;

import io.hexlet.parsers.JsonParser;
import io.hexlet.parsers.Parser;
import io.hexlet.parsers.YamlParser;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class ConfigFactory {
    // BEGIN (write your solution here)
    public static AppConfig build(String filepath) throws Exception {
        var type = getDataFormat(filepath);
        var content = readFile(filepath);
        Parser parser = switch (type) {
            case "json" -> new JsonParser();
            case "yaml", "yml" -> new YamlParser();
            default -> throw new IllegalArgumentException("Format " + type + " not supported");
        };
        var data = parser.parse(content);

        return new AppConfig(data);
    }

    private static String getDataFormat(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0
                ? filePath.substring(index + 1)
                : "";
    }

    private static String readFile(String filepath) throws IOException {
        var fullPath = Paths.get(filepath).toAbsolutePath().normalize();
        return Files.readString(fullPath);
    }
    // END
}
