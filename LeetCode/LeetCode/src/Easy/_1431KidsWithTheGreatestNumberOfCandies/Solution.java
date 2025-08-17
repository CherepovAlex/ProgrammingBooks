package Easy._1431KidsWithTheGreatestNumberOfCandies;

import java.util.ArrayList;
import java.util.List;

// Есть n детей с конфетами. Вам дан целочисленный массив candies,
// где каждое candies[i] обозначает количество конфет у ith ребёнка,
// а также целое число extraCandies, обозначающее количество дополнительных конфет, которые есть у вас.
//Верните массив логических значений result длиной n, где result[i] — это true, если после того,
// как ith ребёнок получит все extraCandies, у него будет наибольшее количество конфет среди всех детей,
// или false в противном случае.
//Обратите внимание, что несколько детей могут получить наибольшее количество конфет.
// Example 1:
//Input: candies = [2,3,5,1,3], extraCandies = 3
//Output: [true,true,true,false,true]
//Explanation: If you give all extraCandies to:
//- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
//- Kid 2, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
//- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
//- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among the kids.
//- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
//Example 2:
//Input: candies = [4,2,1,1,2], extraCandies = 1
//Output: [true,false,false,false,false]
//Explanation: There is only 1 extra candy.
//Kid 1 will always have the greatest number of candies, even if a different kid is given the extra candy.
//Example 3:
//Input: candies = [12,1,12], extraCandies = 10
//Output: [true,false,true]
public class Solution {
    // time O(n), space O(1)
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] > max) {
                max = candies[i];
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= max) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 5, 1, 3};
        int extraCandies = 3;
        System.out.println(new Solution().kidsWithCandies(nums, extraCandies));
    }
}
