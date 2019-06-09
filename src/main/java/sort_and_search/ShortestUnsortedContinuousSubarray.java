package sort_and_search;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int[] copy = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(nums);
        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (copy[left] != nums[left]) {
                break;
            }
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (copy[right] != nums[right]) {
                break;
            }
        }
        return right > left ? right - left + 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 3, 3, 3, 3, 2, 2, 2}));
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[]{1, 2, 3, 4}));
    }
}
