package array;

public class LongestContinuousIncreasingSubsequence {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int max = 1;
        int cur = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                cur += 1;
                max = Math.max(max, cur);
            } else {
                cur = 1;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(new int[]{1, 3, 5, 4, 6}));
    }

}
