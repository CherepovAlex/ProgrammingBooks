package io.hexlet.parsers;

import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonParser implements Parser {
    // BEGIN (write your solution here)
    @Override
    public Map<String, Object> parse(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, new TypeReference<Map<String, Object>>() {
        });
    }
    // END
}
