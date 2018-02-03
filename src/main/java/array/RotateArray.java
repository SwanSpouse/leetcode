package array;


/**
 *  简单题。考察数组利用O(1)的时间复杂度来进行翻转。
 */
public class RotateArray {

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            swap(nums, start ++, end --);
        }
    }

    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }
}