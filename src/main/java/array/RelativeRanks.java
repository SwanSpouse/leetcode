package array;

import utils.Print;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] nums) {
        int[] ranks = Arrays.copyOfRange(nums, 0, nums.length);
        Arrays.sort(ranks);

        HashMap<Integer, Integer> sourceRank = new HashMap<>();
        for (int i = 0; i < ranks.length; i++) {
            sourceRank.put(ranks[i], ranks.length - i);
        }

        String[] ret = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (sourceRank.get(nums[i]) == 1) {
                ret[i] = "Gold Medal";
            } else if (sourceRank.get(nums[i]) == 2) {
                ret[i] = "Silver Medal";
            } else if (sourceRank.get(nums[i]) == 3) {
                ret[i] = "Bronze Medal";
            } else {
                ret[i] = sourceRank.get(nums[i]) + "";
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new RelativeRanks().findRelativeRanks(new int[]{5, 4, 3, 2, 1}));
        Print.printArr(new RelativeRanks().findRelativeRanks(new int[]{3, 1, 4, 2, 5}));
    }
}
