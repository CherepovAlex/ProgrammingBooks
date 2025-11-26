package TwoPointers._2540MinimumCommonValue;

// 2540. Минимальное общее значение
// Даны два массива целых чисел nums1 и nums2, отсортированные в порядке неубывания.
// Верните то наименьшее общее целое число для обоих массивов. Если среди nums1 и nums2 нет общего целого числа, верните -1.
// Обратите внимание, что целое число называется общим для nums1 и nums2, если в обоих массивах есть хотя бы одно
// вхождение этого целого числа.
// Example 1:
//Input: nums1 = [1,2,3], nums2 = [2,4]
//Output: 2
//Explanation: The smallest element common to both arrays is 2, so we return 2.
//Example 2:
//Input: nums1 = [1,2,3,6], nums2 = [2,3,4,5]
//Output: 2
//Explanation: There are two common elements in the array 2 and 3 out of which 2 is the smallest, so 2 is returned.
public class Solution {
    // time O(n + m), space O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        // Инициация двух указателей для обхода массивов
        int i = 0, j = 0;

        // Пока оба указателя в пределах своих массивов
        while (i < nums1.length && j < nums2.length) {
            // Если текущие элементы равны - нашли наименьшее обзее значение
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            }
            // если элемент в nums1 меньше, двигаем указатель nums1
            else if (nums1[i] < nums2[j]) {
                i++;
            }
            // есил элемент в nums2 меньше, двигаем указатель nums2
            else {
                j++;
            }
        }
        // если не нашли общих элементов, возвращаем -1
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4};
        System.out.println(new Solution().getCommon(nums1, nums2)); // 2
    }
}
