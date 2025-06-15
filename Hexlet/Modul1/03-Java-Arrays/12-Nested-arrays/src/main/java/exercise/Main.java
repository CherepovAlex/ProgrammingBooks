// Реализуйте публичный статический метод getSameCount(), который принимает на вход два массива целых чисел.
// Метод должен возвращать количество общих уникальных значений в обоих массивах

package exercise;
import java.util.Arrays;
public class Main {
    public static int getSameCount(int[] coll1, int[] coll2) {
        var uniq1 = Utils.uniq(coll1);
        var uniq2 = Utils.uniq(coll2);

        var count = 0;

        for (var item1 : uniq1) {
            for (var item2 : uniq2) {
                if (item1 == item2) {
                    count++;
                }
            }
        }

        return count;
    }
    // END
    public static void main(String[] args) {
        // Общие уникальные элементы: 1, 3, 2
        System.out.println(Main.getSameCount(new int[]{1, 3, 2, 2}, new int[]{3, 1, 1, 2, 5})); // 3
        // Общие уникальные элементы: 4
        System.out.println(Main.getSameCount(new int[]{1, 4, 4}, new int[]{4, 8, 4})); // 1
        // Общие уникальные элементы: 1, 10
        System.out.println(getSameCount(new int[]{1, 10, 3}, new int[]{10, 100, 35, 1})); // 2
        // Нет элементов
        System.out.println(getSameCount(new int[]{}, new int[]{})); // 0
        // Подсказки
        // Для получения массива без повторяющихся элементов, используйте метод Utils.uniq().
        // Этот метод уже написан в упражнении
        int[] coll = {1, 1, 2, 3, 4, 4};
        int[] uniqColl = Utils.uniq(coll);
        System.out.println(Arrays.toString(uniqColl)); // [1, 2, 3, 4]
        // В целях обучения и прокачки, решите это упражнение с помощью вложенных циклов
    }
}