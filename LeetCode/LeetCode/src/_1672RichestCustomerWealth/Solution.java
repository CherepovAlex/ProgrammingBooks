package _1672RichestCustomerWealth;
// Вам дана m x n целочисленная матрица accounts, где accounts[i][j] — это сумма денег, которую клиент хранит в банке.
// Верните самого богатство клиента.
//Состояние клиента — это сумма денег на всех его банковских счетах.
// Самый богатый клиент — это клиент с максимальным состоянием.
//Example 1:
//Input: accounts = [[1,2,3],[3,2,1]]
//Output: 6
//Explanation:
//1st customer has wealth = 1 + 2 + 3 = 6
//2nd customer has wealth = 3 + 2 + 1 = 6
//Both customers are considered the richest with a wealth of 6 each, so return 6.
//Example 2:
//Input: accounts = [[1,5],[7,3],[3,5]]
//Output: 10
//Explanation:
//1st customer has wealth = 6
//2nd customer has wealth = 10
//3rd customer has wealth = 8
//The 2nd customer is the richest with a wealth of 10.
//Example 3:
//Input: accounts = [[2,8,7],[7,1,3],[1,9,5]]
//Output: 17
public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = Integer.MIN_VALUE;

        for(int[] customer : accounts){
            int currentCustomerWealth = 0;

            for(int bank : customer){
                currentCustomerWealth += bank;
            }
            maxWealthSoFar = Math.max(currentCustomerWealth, maxWealthSoFar);
        }
        return maxWealthSoFar;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maximumWealth(new int[][]{{1, 2, 3}, {2, 8, 7}, {1, 9, 5}}));
    }
}
