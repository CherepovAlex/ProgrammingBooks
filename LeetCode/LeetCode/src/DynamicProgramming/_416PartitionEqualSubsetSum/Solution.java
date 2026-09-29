package DynamicProgramming._416PartitionEqualSubsetSum;
// 416. Равномерное разбиение на подмножества
//Дан целочисленный массив nums. Верните true , если массив можно разделить на два подмножества так, чтобы сумма
// элементов в обоих подмножествах была равна, или false, если это невозможно.
// Example 1:
//Input: nums = [1,5,11,5]
//Output: true
//Explanation: The array can be partitioned as [1, 5, 5] and [11].
//Example 2:
//Input: nums = [1,2,3,5]
//Output: false
//Explanation: The array cannot be partitioned into equal sum subsets.
public class Solution {
    // time O(n * target), n элементов, target - половина общей суммы, space O(target)
    public boolean canPartition(int[] nums) {
        // Вычисляем общую сумму всех элементов массива
        int totalSum = 0;
        // Проходим по всем элементам массива и суммируем их
        for(int num : nums) {
            totalSum += num;
        }

        // Если общая сумма нечетная, разбиение на две равные части невозможно
        if (totalSum % 2 != 0) return false;

        // Целевая сумма для каждого подмножества (половина общей суммы)
        int target = totalSum / 2;

        // Создаём булевый массив для динамического программирования
        // dp[i] = true, если сумму i можно получить из элементов массива
        boolean[] dp = new boolean[target + 1];

        // Нулевую сумму всегда можно получить (пустое подмножество)
        dp[0] = true;

        // Перебираем все числа из исходного массива
        for (int num : nums) {
            // Перебираем суммы в обратном порядке, чтобы избежать повторного использования элемента
//            System.out.println("num: " + num);
            for (int j = target; j >= num; j--) {
//                System.out.println("j= " + j);
                // Если сумму (j - num) можно получить, то и сумму j тоже можно получить
                // добавив текущий элемент num
                if (dp[j - num]) {
                    dp[j] = true;

//                    System.out.println("dp[j - num]: " + dp[j] + " " + num + " = " + (dp[j - num]));
//                    System.out.println("dp[j] = " + dp[j] + " j = " + j);
                }
            }
        }
        // Возвращаем, можно ли получить целевую сумму
        return dp[target];
    }
    // Ключевые моменты алгоритма:
    //Проверка четности суммы - если сумма всех элементов нечетная, разбиение невозможно.
    //Динамическое программирование - используем подход "subset sum" для нахождения, можно ли получить сумму target = totalSum/2.
    //Обратный порядок обхода - при переборе сумм от target до num в обратном порядке мы гарантируем, что каждый элемент будет использован не более одного раза.
    //Оптимизация памяти - используем одномерный массив вместо двумерного, что снижает потребление памяти с O(n × target) до O(target).
    //Временная сложность: O(n × target), где n - количество элементов, target - половина суммы.
    //Пространственная сложность: O(target), так как используем массив размером target + 1.

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Solution().canPartition(nums));
    }
}
