package io.hexlet.parsers;

import java.util.Map;
import java.util.Objects;

public interface Parser {
    // BEGIN (write your solution here)
    Map<String, Object> parse (String content) throws Exception;
    // END
}
