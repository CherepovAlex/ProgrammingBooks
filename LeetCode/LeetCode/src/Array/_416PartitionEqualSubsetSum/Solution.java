package Array._416PartitionEqualSubsetSum;
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
        for(int num : nums) {
            totalSum += num;
        }

        // Если общая сумма не четная, разбиение невозможно
        if (totalSum % 2 != 0) return false;

        // Целевая сумма для каждого подмножества
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

    public static void main(String[] args) {
        int[] nums = {1,5,11,5};
        System.out.println(new Solution().canPartition(nums));
    }
}
