package detail;

import java.util.Arrays;

/**
    简单题，找规律
 */
public class ArrayPartitionI {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int ret = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ret += nums[i];
        }
        return ret;
    }
}
