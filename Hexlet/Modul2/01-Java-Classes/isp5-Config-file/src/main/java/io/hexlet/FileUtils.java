package io.hexlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileUtils {
    public static String getConfigData(String property) throws IOException {
        var properties = new Properties();

        try (InputStream input = FileUtils.class.getClassLoader().getResourceAsStream("application.properties")) {
            properties.load(input);
            return properties.getProperty(property);
        }
    }
}
