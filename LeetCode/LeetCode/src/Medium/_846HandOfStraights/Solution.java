package Medium._846HandOfStraights;
// У Алисы есть несколько карт, и она хочет разложить их по группам так,
// чтобы каждая группа состояла из groupSize последовательных карт и имела размер groupSize.
//Дан целочисленный массив hand, где hand[i] — значение, записанное на карточке ith, и целое число groupSize.
// Верните true, если она может переставить карточки, или false в противном случае.

import java.util.TreeMap;

// Example 1:
//Input: hand = [1,2,3,6,2,3,4,7,8], groupSize = 3
//Output: true
//Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
//Example 2:
//Input: hand = [1,2,3,4,5], groupSize = 4
//Output: false
//Explanation: Alice's hand can not be rearranged into groups of 4.
public class Solution {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        // 1. Создание TreeMap для подсчета количества каждой карты
        TreeMap<Integer, Integer> card_counts = new TreeMap<>();

        // 2. Заполнение TreeMap: ключ - значение карты, значение - количество
        for (int card : hand) {
            if (!card_counts.containsKey(card)) {
                card_counts.put(card, 1);
            } else {
                card_counts.replace(card, card_counts.get(card) + 1);
            }
        }

        // 3. Основной алгоритм: пока есть карты в TreeMap
        while (card_counts.size() > 0) {
            // Берем наименьшую доступную карту
            int first_card = card_counts.firstKey();

            // 4. Пытаемся построить группу из groupSize последовательных карт
            for (int i = first_card; i < first_card + groupSize; i++) {
                // Если нужной карты нет - возвращаем false
                if (!card_counts.containsKey(i)) return false;

                int count = card_counts.get(i);
                // Уменьшаем счетчик или удаляем карту
                if (count == 1) {
                    card_counts.remove(i);
                } else {
                    card_counts.replace(i, card_counts.get(i) - 1);
                }
            }
        }
        return true;
    }
    // time O(n log n + n × groupSize) в худшем случае, space O(n) для хранения TreeMap
    public boolean isNStraightHand2(int[] hand, int groupSize) {
        // Проверка базового случая: нельзя разбить на группы нужного размера
        if (hand.length % groupSize != 0) {
            return false;
        }
        // Создание TreeMap для подсчета количества каждой карты
        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        // Более эффективное заполнение TreeMap
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }
        // Основной алгоритм: пока есть карты в TreeMap
        while (!cardCounts.isEmpty()) {
            int firstCard = cardCounts.firstKey(); // Берем наименьшую доступную карту

            // Пытаемся построить группу, начиная с firstCard
            for (int i = 0; i < groupSize; i++) {
                int currentCard = firstCard + i;

                // Если карты нет, группа не может быть построена
                if (!cardCounts.containsKey(currentCard)) {
                    return false;
                }

                // Уменьшаем счетчик
                int count = cardCounts.get(currentCard);
                if (count == 1) {   // или удаляем карту
                    cardCounts.remove(currentCard);
                } else {            // или Уменьшаем счетчик
                    cardCounts.put(currentCard, count - 1);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] hand = {1, 2, 3, 6, 2, 3, 4, 7, 8};
        int groupSize = 3;
        System.out.println(new Solution().isNStraightHand(hand, groupSize));
    }
}
