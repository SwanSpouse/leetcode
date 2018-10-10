package array;

import java.util.Arrays;

public class MaximumProductOfThreeNumbers {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int last = nums.length - 1;
        if (nums[0] * nums[1] > nums[last - 1] * nums[last - 2]) {
            return nums[0] * nums[1] * nums[last];
        } else {
            return nums[last] * nums[last - 1] * nums[last - 2];
        }
    }
}
