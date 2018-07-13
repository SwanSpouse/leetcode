package dynamic_programing;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int maxVal = Integer.MIN_VALUE;
        for (int start = 0; start < nums.length; start++) {
            int temp = 0;
            for (int end = start; end < nums.length; end++) {
                if (start == end) {
                    temp = nums[start];
                } else {
                    temp *= nums[end];
                }
                maxVal = maxVal < temp ? temp : maxVal;
            }
        }
        return maxVal;
    }
}
