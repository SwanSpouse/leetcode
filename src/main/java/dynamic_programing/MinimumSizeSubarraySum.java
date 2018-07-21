package dynamic_programing;

/**滑动窗口
 */
public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        int sum = nums[left];
        int min = Integer.MAX_VALUE;

        while (true) {
            if (sum < s) {
                if (right == nums.length - 1) {
                    return min == Integer.MAX_VALUE ? 0 : min;
                }
                sum += nums[++right];
            } else {
                min = min < right - left + 1 ? min : right - left + 1;
                if (left == right) {
                    return min == Integer.MAX_VALUE ? 0 : min;
                }
                sum -= nums[left++];
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}
