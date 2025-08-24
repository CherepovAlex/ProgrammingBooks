package Easy._1550ThreeConsecutiveOdds;
// Дан целочисленный массив arr.
// Верните true, если в массиве есть три последовательных нечётных числа. В противном случае верните false.
// Example 1:
//Input: arr = [2,6,4,1]
//Output: false
//Explanation: There are no three consecutive odds.
//Example 2:
//Input: arr = [1,2,34,3,4,5,7,23,12]
//Output: true
//Explanation: [5,7,23] are three consecutive odds.
public class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                count++;
            } else {
                count = 0;
            }
            if (count == 3) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,6,4,1}; // false
        System.out.println(new Solution().threeConsecutiveOdds(nums));
    }

}
