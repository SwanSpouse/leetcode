package dfs;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean dfs(int[] nums, int index, int cur, int target) {
        if (index >= nums.length || cur > target) {
            return false;
        }
        if (cur == target) {
            return true;
        }
        for (int i = index; i < nums.length; i++) {
            if (dfs(nums, i + 1, cur, target)) {
                return true;
            }
            if (dfs(nums, i + 1, cur + nums[i], target)) {
                return true;
            }
        }
        return false;
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        return dfs(nums, 0, 0, sum / 2);
    }

    public static void main(String[] args) {
//        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(new PartitionEqualSubsetSum().canPartition(new int[]{1, 2, 5}));
    }
}
