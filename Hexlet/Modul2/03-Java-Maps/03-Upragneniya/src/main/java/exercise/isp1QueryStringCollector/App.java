package exercise.isp1QueryStringCollector;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class App {

    public static String bqs(Map<String, String> map) {
        var result = new ArrayList<String>();
        for (var entry : map.entrySet()) {
            result.add(entry.getKey() + "=" + entry.getValue());
        }
        return String.join("&", result);
    }

    public static void main(String[] args) {

        var params = new LinkedHashMap<String, String>();
        params.put("page", "1");
        params.put("per", "10");

        System.out.println(App.bqs(params)); // "page=1&per=10"
    }
}
