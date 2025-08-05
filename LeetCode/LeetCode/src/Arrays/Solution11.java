package Arrays;
// Удалите дубликаты из отсортированного массива
// Дан целочисленный массив nums, отсортированный в порядке неубывания.
// Удалите дубликаты на месте так, чтобы каждый уникальный элемент встречался только один раз.
// Относительный порядок элементов должен остаться прежним. Затем верните количество уникальных элементов в nums.
//Предположим, что количество уникальных элементов в nums равно k, чтобы получить одобрение,
// вам нужно сделать следующее:
//Измените массив nums таким образом, чтобы первые k элементы nums содержали уникальные элементы в том порядке,
// в котором они присутствовали nums изначально. Остальные элементы nums не так важны, как размер nums.
//Возврат k.
public class Solution11 {
    // time O(n)
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 2};    // [1, 2]
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};   // [0, 1, 2, 3, 4]
        System.out.println(new Example6().removeDuplicates(nums1));
        System.out.println(new Example6().removeDuplicates(nums2));
    }

}
