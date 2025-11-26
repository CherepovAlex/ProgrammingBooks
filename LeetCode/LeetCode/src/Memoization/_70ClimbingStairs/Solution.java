package Memoization._70ClimbingStairs;

import java.util.HashMap;
import java.util.Map;

// Вы поднимаетесь по лестнице. Чтобы добраться до вершины, нужно сделать n шагов.
// Каждый раз вы можете подняться либо на 1 ступеней, либо на 2 ступеней.
// Сколькими различными способами можно подняться на вершину?
//  Example 1:
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//  Example 2:
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
public class Solution {
    // Кэш для хранения уже вычисленных результатов (мемоизация)
    private final Map<Integer, Integer> map = new HashMap<>();
    // time O(n), space O(n)
    public int climbStairs(int n) {
        return stairs(0, n); // Начинаем с 0-й ступеньки, цель - n
    }

    private int stairs(int current, final int target) {
        if (current == target) {
            return 1;           // Достигли вершины - 1 валидный путь
        }
        if (current > target) {
            return 0;           // Перешагнули вершину - невалидный путь
        }
        // Проверяем, вычисляли ли уже для этой позиции
        if (map.containsKey(current)) { // Мемоизация: если уже вычисляли для этой позиции
            //Возвращаем сохраненный результат
            return map.get(current);
        }
        // Рекурсивно считаем пути: шаг на 1 ИЛИ шаг на 2 ступеньки
        int ways = stairs(current + 1, target) + stairs(current + 2, target);
        map.put(current, ways);  // Сохраняем результат в кэш для повторного использования
        return ways;             // Возвращаем количество способов для текущей позиции
    }

    // time O(n) space O(1)
    public int climbStairs2(int n) {
        // Базовые случаи: для 1 и 2 ступенек ответы известны
        if (n <= 2) return n;

        // Инициализация переменных для хранения промежуточных результатов
        int prev1 = 1; // Количество способов для (n-2) ступенек
        int prev2 = 2; // Количество способов для (n-1) ступенек
        int current = 0; // Будет хранить текущий результат

        // Основной цикл: вычисляем количество способов для каждой ступеньки от 3 до n
        for (int i = 3; i <= n; i++) {
            // Текущее количество способов = сумма способов для двух предыдущих ступенек
            current = prev1 + prev2;

            // Обновляем значения для следующей итерации
            prev1 = prev2; // Теперь prev1 становится способами для (i-1)
            prev2 = current; // prev2 становится способами для i
        }
        // Возвращаем результат для n ступенек
        return prev2;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(new Solution().climbStairs(n));
        int n1 = 4;
        System.out.println(new Solution().climbStairs(n1));
    }
}
