package array;

import java.util.HashMap;

/**
 *  简单题
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (indexMap.containsKey(left)) {
                return new int[]{indexMap.get(left), i};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ret = twoSum(input, target);

        System.out.println("" + ret[0] + " " + ret[1]);
    }
}
