package exercise.Consultation1;

//Дан массив nums = [3,2,2,3] и число val = 3.
//Если в массиве есть числа, равные заданному, нужно перенести эти элементы в конец массива.
//Таким образом, первые несколько (или все) элементов массива должны быть отличны от заданного, а остальные - равны ему.

import java.util.Arrays;

public class Nums {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(nums);

        System.out.println(Arrays.toString(nums));

        moveValToEnd(nums, val);

        System.out.println(Arrays.toString(nums));
    }

    public static void moveValToEnd(int[] nums, int val) {
        int write = 0;
        for (int num: nums) {
            if (num != val) {
                nums[write++] = num;
            }
            System.out.println(Arrays.toString(nums));
        }

        while (write < nums.length) {
            nums[write++] = val;
        }

    }
}
