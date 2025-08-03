package _1672RichestCustomerWealth;

public class Solution {
    public int maximumWealth(int[][] accounts) {
        int maxWealthSoFar = 0;

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
        Solution solution = new Solution();
        System.out.println(solution.maximumWealth(new int[][]{{1, 2, 3}, {2, 8, 7}, {1, 9, 5}}));
    }
}
