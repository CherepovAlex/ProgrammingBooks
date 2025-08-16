package Easy._1046LastStoneWeight;

import java.util.Comparator;
import java.util.PriorityQueue;

// Вам дан массив целых чисел stones, где stones[i] — вес i-th-го камня.
//Мы играем в игру с камнями. На каждом ходу мы выбираем два самых тяжёлых камня и сталкиваем их.
// Предположим, что два самых тяжёлых камня весят x и y с x <= y. Результат этого столкновения:
//Если x == y, то оба камня будут уничтожены, и
//Если x != y, то камень весом x будет уничтожен, а камень весом y станет весить y - x.
//В конце игры остаётся не более одного камня.
//Верните вес последнего оставшегося камня. Если камней не осталось, верните 0.
// Example 1:
//Input: stones = [2,7,4,1,8,1]
//Output: 1
//Explanation:
//We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
//we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
//we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
//we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
//Example 2:
//Input: stones = [1]
//Output: 1
//
public class Solution {
    // time O(n log n)
    public int lastStoneWeight(int[] stones) {
        // Создание приоритетной очереди с компаратором - сортирует элементы в порядке убывания (максимальная куча)
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o2 - o1;
                    }
                }
        );
        // Заполнение очереди всеми камнями из входного массива
        for (int stone : stones) {
            pq.offer(stone);
        }
        // Цикл продолжается, пока в очереди больше одного камня.
        while (pq.size() > 1) {
            // На каждой итерации извлекаются два самых тяжелых камня (первые в очереди)
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            // Если камни разного веса, добавляем обратно разницу весов.
            if (stone1 > stone2) {
                pq.add(stone1 - stone2);
            }
        }
        // После завершения цикла проверяем, остался ли камень:
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 7, 4, 1, 8, 1};
        System.out.println(new Solution().lastStoneWeight(stones));
    }
}
