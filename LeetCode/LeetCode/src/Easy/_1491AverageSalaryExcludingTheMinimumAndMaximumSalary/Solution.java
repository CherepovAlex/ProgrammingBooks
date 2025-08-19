package Easy._1491AverageSalaryExcludingTheMinimumAndMaximumSalary;

// Вам дан массив уникальных целых чисел salary, где salary[i] — зарплата ith сотрудника.
//Верните среднюю зарплату сотрудников без учёта минимальной и максимальной зарплаты.
// Будут приняты ответы, совпадающие с фактическим ответом в пределах 10-5 %.
// Example 1:
//Input: salary = [4000,3000,1000,2000]
//Output: 2500.00000
//Explanation: Minimum salary and maximum salary are 1000 and 4000 respectively.
//Average salary excluding minimum and maximum salary is (2000+3000) / 2 = 2500
//Example 2:
//Input: salary = [1000,2000,3000]
//Output: 2000.00000
//Explanation: Minimum salary and maximum salary are 1000 and 3000 respectively.
//Average salary excluding minimum and maximum salary is (2000) / 1 = 2000
public class Solution {
    // time O(n) space O(1)
    public double average(int[] salary) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int j : salary) {
            if (j < min) {
                min = j;
            }
            if (j > max) {
                max = j;
            }
            sum += j;
        }
        double newSum = sum - min - max;
        double newLength = salary.length - 2;
        return newSum / newLength;
    }

    public static void main(String[] args) {
        int[] nums = {4000, 3000, 1000, 2000};
        System.out.println(new Solution().average(nums));
    }
}
