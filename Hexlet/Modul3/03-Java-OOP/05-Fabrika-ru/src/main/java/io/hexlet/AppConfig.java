package io.hexlet;

import lombok.AllArgsConstructor;

import java.util.Map;


@AllArgsConstructor
public class AppConfig {
    private Map<String, Object> data;

    public Object get(String key) {
        Object result = data.get(key);
        if (result instanceof Map) {
            return new AppConfig((Map<String, Object>) result);
        }
        return result;
    }
}
