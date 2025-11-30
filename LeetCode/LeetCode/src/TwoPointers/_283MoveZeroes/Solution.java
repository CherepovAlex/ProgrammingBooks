package TwoPointers._283MoveZeroes;

import java.util.Arrays;

// 283. Переместите нули
// Дан целочисленный массив nums. Переместите все 0 в конец массива, сохранив относительный порядок ненулевых элементов.
//Обратите внимание, что это нужно делать на месте, без создания копии массива.
// Example 1:
//Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
//Example 2:
//Input: nums = [0]
//Output: [0]
public class Solution {
    // time O(n) - линейная временная сложность, space O(1)
    public void moveZeroes(int[] nums) {
        // Проверка на null и пустой массив для безопасности
        if (nums == null || nums.length == 0) {
            return; // Выход из метода если массив пустой или null
        }
        // Указатель для записи ненулевых элементов
        int nonZeroIndex = 0;
        // Первый проход: перемещаем все ненулевые элементы в начало массива
        for (int i = 0; i < nums.length; i++) {
            // Если текущий элемент не равен нулю
            if (nums[i] != 0) {
                // Записываем ненулевой элемент на позицию nonZeroIndex
                // Проверка i != nonZeroIndex избегает ненужных присваиваний
                if (i != nonZeroIndex) {
                    nums[nonZeroIndex] = nums[i];   // Перемещаем ненулевой элемент
                }
                nonZeroIndex++; // Увеличиваем указатель для следующего ненулевого элемента
            }
        }
        // Второй проход: заполняем оставшуюся часть массива нулями
        for (int i = nonZeroIndex; i < nums.length; i++) {
            nums[i] = 0;    // Заполняем нулями все позиции после последнего ненулевого элемента
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
