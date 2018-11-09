package dfs;

import java.util.*;

public class CombinationSumIV {

//    public void dfs(Set<List<Integer>> set, List<Integer> curList, int[] nums, int cur, int target) {
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] + cur > target) {
//                return;
//            }
//            curList.add(nums[i]);
//            if (nums[i] + cur == target) {
//                set.add(new ArrayList<>(curList));
//            } else {
//                dfs(set, curList, nums, cur + nums[i], target);
//            }
//            curList.remove(curList.size() - 1);
//        }
//    }
//
//    public int combinationSum4(int[] nums, int target) {
//        List<Integer> cur = new ArrayList<>();
//        Set<List<Integer>> set = new HashSet<>();
//
//        Arrays.sort(nums);
//        dfs(set, cur, nums, 0, target);
//
//        return set.size();
//    }


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;

        Arrays.sort(nums);

        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num > i) {
                    break;
                } else if (num == i) {
                    dp[i] += 1;
                } else if (num < i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 3}, 4));
        System.out.println(new CombinationSumIV().combinationSum4(new int[]{1, 2, 4}, 32));
    }
}
