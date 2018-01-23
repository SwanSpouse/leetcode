package dynamic_programing;

/**
 * 典型的dp问题。
 *      dp[0] = nums[0];
 *      dp[i] = max(dp[i-1], nums[i] + dp[i-1])
 */
class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i= 1; i < nums.length; i ++ ) {
            dp[i] = dp[i-1] > 0 ? dp[i-1] + nums[i] : nums[i];
            max = dp[i] > max ? dp[i] : max;
        }
        return max;
    }
}