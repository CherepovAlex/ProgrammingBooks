package Hard._42TrappingRainWater;
// Дано n неотрицательных целых чисел, представляющих собой карту высот, где ширина каждой полосы равна 1.
// Вычислите, сколько воды может скопиться на ней после дождя.

// Example 1:
//Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6
//Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//Example 2:
//Input: height = [4,2,0,3,2,5]
//Output: 9
public class Solution {
    // time O(n), space O(n)
    public int trap(int[] height) {
        int n = height.length;  // получаем длину массива высот
        if (n < 3) return 0;    // если меньше 3 элементов, вода не может удерживаться

        // left[i] содержит максимальную высоту слева от позиции i (включая саму позицию i)
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = i == 0 ? height[i] : Math.max(left[i - 1], height[i]);
        }
        // right[i] содержит максимальную высоту справа от позиции i (включая саму позицию i)
        int[] right = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = i == n - 1 ? height[i] : Math.max(right[i + 1], height[i]);
        }
        // Вычисление общего объема воды:
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(right[i], left[i]) - height[i];
        } // Для каждой позиции i: количество воды = минимальная высота "стенок" слева и справа
        return sum;                                      // минус высота самой позиции
    }
    // time O(n), space O(1)
    public int trap1(int[] height) {
        int n = height.length;
        if (n < 3) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Solution().trap(height));

    }
}
