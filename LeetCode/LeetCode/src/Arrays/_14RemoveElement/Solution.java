package Arrays._14RemoveElement;
// Дан целочисленный массив nums и целое число val. Удалите все вхождения val в nums на месте.
// Порядок элементов может измениться. Затем верните количество элементов в nums, которые не равны val.
//Пусть количество элементов в nums, которые не равны val, равно k. Чтобы получить одобрение,
// вам нужно сделать следующее:
//Измените массив nums таким образом, чтобы первые k элементов nums содержали элементы, которые не равны val.
// Остальные элементы nums не важны, как и размер nums.
//Возврат k.
// Example 1:
//Input: nums = [3,2,2,3], val = 3
//Output: 2, nums = [2,2,_,_]
//Explanation: Your function should return k = 2, with the first two elements of nums being 2.
//It does not matter what you leave beyond the returned k (hence they are underscores).
//Example 2:
//Input: nums = [0,1,2,2,3,0,4,2], val = 2
//Output: 5, nums = [0,1,4,0,3,_,_,_]
//Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
//Note that the five elements can be returned in any order.
//It does not matter what you leave beyond the returned k (hence they are underscores).
public class Solution {
    // time O(n), space O(1)
    public int removeElement(int[] nums, int val) {
        // инициация указателей
        int left = 0;
        int right = nums.length - 1;
        // пока указатели не пересекутся
        while (left <= right) {
            // если нашли
            if (nums[left] == val) {
                // то заменяем на символ справа
                nums[left] = nums[right];
                // двигаем указатель
                right--;
            } else {
                // если не нашли
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        int val = 3;
        System.out.println(new Solution().removeElement(nums, val));

        int[] nums1 = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        int val1 = 2;
        System.out.println(new Solution().removeElement(nums1, val1));
    }

}
