package Greedy._122BestTimeToBuyAndSellStockII;
// 122. Лучшее время для покупки и продажи акций II
// Вам дан целочисленный массив prices, где prices[i] — цена определённой акции в ith-й день.
// Каждый день вы можете принимать решение о покупке и/или продаже акций.
// В любой момент времени вы можете владеть не более чем одной акцией.
// Однако вы можете купить акцию, а затем сразу же продать её в тот же день.
// Найдите и верните прибыль, которую вы можете получить
// Example 1:
//Input: prices = [7,1,5,3,6,4]
//Output: 7
//Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
//Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
//Total profit is 4 + 3 = 7.
//Example 2:
//Input: prices = [1,2,3,4,5]
//Output: 4
//Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
//Total profit is 4.
//Example 3:
//
//Input: prices = [7,6,4,3,1]
//Output: 0
//Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
public class Solution {
    // time O(n), space O(1)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) return 0; // Если дней меньше 2, торговля невозможна

        int total = 0;  // Итоговая  прибыль
        int min = prices[0];    // Минимальная цена для покупки

        for (int i = 1; i < n; i++) {
            int profit = prices[i] - min;   // Потенциальная прибыль
            if (profit > 0) {
                total += profit; // Фиксируем прибыль
                min = prices[i]; // Сбрасываем минимум
            }
            min = Math.min(min, prices[i]); // Обновляем минимум
        }
        return total;
    }

    public int maxProfit1(int[] prices) {
        int totalProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                totalProfit += prices[i] - prices[i-1];
            }
        }
        return totalProfit;
    }

    public static void main(String[] args) {
        int[] nums = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(nums));
    }
}
