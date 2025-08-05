package Arrays;

public class Solution2 {

    public int findNumbers(int[] nums) {
        int countEven = 0;

        for (var num : nums) {
            int digitCount = countDigits(num);
            if (digitCount % 2 == 0) {
                countEven++;
            }
        }
        return countEven;
    }

    private int countDigits(int num) {
        if (num == 0) return 1;

        int count = 0;
        num = Math.abs(num);

        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {12, 324, 2, 6, 7896};
        System.out.println(new Solution2().findNumbers(nums1));

        int[] nums2 = {555, 901, 482, 1771};
        System.out.println(new Solution2().findNumbers(nums2));
    }
}
