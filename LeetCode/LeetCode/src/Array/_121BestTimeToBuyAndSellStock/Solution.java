package Array._121BestTimeToBuyAndSellStock;
// 121. Лучшее время для покупки и продажи акций
//Вам дан массив prices, где prices[i] — цена определённой акции в i-th-й день.
//Вы хотите получить максимальную прибыль, выбрав один день для покупки одной акции
// и другой день в будущем для её продажи.
//Верните максимальную прибыль, которую вы можете получить от этой сделки.
// Если вы не можете получить прибыль, верните 0.
// Example 1:
//Input: prices = [7,1,5,3,6,4]
//Output: 5
//Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
//Example 2:
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: In this case, no transactions are done and the max profit = 0.
public class Solution {
    // time O(n). space O(1)
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE; // Инициализируем минимальную цену максимально возможны
        int maxProfit = 0;           // Инициализируем максимальную прибыль нулем
        for (int i = 0; i < prices.length; i++) {   // Проходим по всем ценам
            if (prices[i] < min) {                  // Если текущая цена меньше известного минимума
                min = prices[i];                    // Обновляем минимум
            }
            int currentProfit = prices[i] - min;    // Вычисляем потенциальную прибыль
            if (currentProfit > maxProfit) {        // Если текущая прибыль больше максимальной
                maxProfit = currentProfit;          // Обновляем максимальную прибыль
            }
        }
        return maxProfit;   // Возвращаем результат
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{7, 1, 5, 3, 6, 4};    // 5
        int[] nums2 = new int[]{7, 6, 4, 3, 1};      // 0
        System.out.println(new Solution().maxProfit(nums1));
        System.out.println(new Solution().maxProfit(nums2));
    }
}
