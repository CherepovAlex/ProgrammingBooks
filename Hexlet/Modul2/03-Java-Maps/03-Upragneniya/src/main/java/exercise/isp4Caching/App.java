package exercise.isp4Caching;

import java.util.LinkedHashMap;

public class App {

    public static void main(String[] args) {

        // Создаем кэш с максимальной емкостью в 2 элемента
        var cache = new Cache(2);

        // Добавляем туда два запроса
        cache.put("praesent", "imperdiet et commodo vulputate");
        cache.put("amet erat", "in tempus sit amet");

        // Обращаемся к кэшу и получаем из него ответы на запросы
        cache.get("praesent"); // imperdiet et commodo vulputate
        cache.get("amet erat"); // in tempus sit amet
        cache.get("some request"); // null

        // Добавляем в кэш третий элемент
        cache.put("justo sit", "auctor sed tristique in");

        cache.get("justo sit"); // auctor sed tristique in
        cache.get("amet erat"); // in tempus sit amet

        // Так как емкость кеша равна 2, самый старый запрос должен быть удален
        cache.get("praesent"); // null

    }

}

// BEGIN
class Cache {

    private int maxSize;
    private LinkedHashMap<String, String> cache;

    Cache(int maxSize) {
        this.maxSize = maxSize;
        cache = new LinkedHashMap<String, String>();
    }

    public void put(String key, String value) {
        cache.put(key, value);

        if (cache.size() > maxSize) {
            removeOldestEntry();
        }
    }

    public String get(String key) {
        return cache.get(key);
    }

    private void removeOldestEntry() {
        var eldest = cache.entrySet().iterator().next();
        cache.remove(eldest.getKey());
    }
}
//END