package array;

import java.util.HashMap;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i] - 1)) {
                max = Math.max(max, map.get(nums[i] - 1) + map.get(nums[i]));
            }
            if (map.containsKey(nums[i] + 1)) {
                max = Math.max(max, map.get(nums[i] + 1) + map.get(nums[i]));
            }
        }
        return max;
    }
}
