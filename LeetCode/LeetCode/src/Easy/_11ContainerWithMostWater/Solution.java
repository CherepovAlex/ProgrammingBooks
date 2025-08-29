package Easy._11ContainerWithMostWater;

// Вам дан целочисленный массив height.
// Уникальные элементы массива — это элементы, которые встречаются n в массиве n
// Вертикальные линии проведены таким образом, что две конечные точки линии i-th — это (i, 0) и (i, height[i]).
//Возврат
//Верните максимальное количество воды, которое может вместить контейнер.
//Пример 1: контейнер нельзя наклонять.
// Example 1:
//Input: height = [1,8,6,2,5,4,8,3,7]
//Output: 49
//Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
// In this case, the max area of water (blue section) the container can contain is 49.
//Example 2:
//
//Input: height = [1,1]
//Output: 1
public class Solution {
    // time O(n), space O(1)
    public int maxArea(int[] height) {
        int max_area = 0;   // Инициализация переменной для хранения максимальной площади
        int a_pointer = 0;  // Левый указатель (начало массива)
        int b_pointer = height.length - 1; // Правый указатель (конец массива)
        // Основной алгоритм - два указателя
        while (a_pointer < b_pointer) {
            if (height[a_pointer] < height[b_pointer]) {
                // Если левая линия короче правой
                max_area = Math.max(max_area, height[a_pointer] * (b_pointer - a_pointer));
                a_pointer += 1; // Двигаем левый указатель вправо
            } else {
                // Если правая линия короче или равна левой
                max_area = Math.max(max_area, height[b_pointer] * (b_pointer - a_pointer));
                b_pointer -= 1; // Двигаем правый указатель влево
            }
        }
        return max_area;
    }

    public int maxArea1(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int currentHeight = Math.min(height[left], height[right]);
            int currentWidth = right - left;
            int currentArea = currentHeight * currentWidth;

            maxArea = Math.max(maxArea, currentArea);

            // Двигаем указатель с меньшей высотой
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public int maxArea2(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, minHeight * (right - left));

            // Пропускаем все линии, которые не могут дать большую площадь
            while (left < right && height[left] <= minHeight) {
                left++;
            }
            while (left < right && height[right] <= minHeight) {
                right--;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Solution().maxArea(heights));
    }
}
