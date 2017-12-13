package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 这个题难点在怎么样去除重复。值得思考。
 */
public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right && right < nums.length) {
                    int cur = nums[i] + nums[j] + nums[left] + nums[right];
                    if (cur == target) {
                        ret.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    }
                    if (cur <= target) {
                        do {
                            left += 1;
                        } while (left < right && nums[left] == nums[left - 1]);
                    }
                    if (cur >= target) {

                        do {
                            right -= 1;
                        } while (left < right && nums[right] == nums[right + 1]);
                    }
                }
            }
        }
        return ret;
    }
}
