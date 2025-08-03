package exercise.isp5DifferCount;

// BEGIN
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

class App {
    public static Map<String, String> genDiff(Map<String, Object> data1, Map<String, Object> data2) {

        var result = new LinkedHashMap<String, String>();
        var keys = new TreeSet<String>(data1.keySet());
        keys.addAll(data2.keySet());

        keys.forEach(key -> {
            if (!data1.containsKey(key)) {
                result.put(key, "added");
            } else if (!data2.containsKey(key)) {
                result.put(key, "deleted");
            } else if (data1.get(key).equals(data2.get(key))) {
                result.put(key, "unchanged");
            } else {
                result.put(key, "changed");
            }
        });

        return result;
    }

    public static void main(String[] args) {

        var data1 = new HashMap<String, Object>(
                Map.of("one", "eon", "two", "two", "four", true)
        );
        System.out.println(data1); //=> {two=two, four=true, one=eon}

        var data2 = new HashMap<String, Object>(
                Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data2); //=> {zero=4, two=own, four=true}

        var result = App.genDiff(data1, data2);
        System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }
}
//END