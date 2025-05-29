package io.hexlet.parsers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class YamlParser implements Parser {
    // BEGIN (write your solution here)
    @Override
    public Map<String, Object> parse(String content) throws Exception {
        var mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
    }
    // END
}
