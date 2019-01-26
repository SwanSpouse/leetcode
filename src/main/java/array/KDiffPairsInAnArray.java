package array;

import java.util.HashMap;
import java.util.HashSet;

public class KDiffPairsInAnArray {
    public int findPairs(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer, Integer> ret = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - k)) {
                ret.put(nums[i] - k, nums[i]);
            }
            if (set.contains(nums[i] + k)) {
                ret.put(nums[i], nums[i] + k);
            }
            set.add(nums[i]);
        }
        return ret.size();
    }

    public static void main(String[] args) {
        System.out.println(new KDiffPairsInAnArray().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(new KDiffPairsInAnArray().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        System.out.println(new KDiffPairsInAnArray().findPairs(new int[]{1, 3, 1, 5, 4, 1}, 0));
    }
}
