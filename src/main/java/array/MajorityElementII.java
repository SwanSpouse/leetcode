package array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ret = new ArrayList<Integer>();
        int candidate1 = 0;
        int count1 = 0;
        int candidate2 = 0;
        int count2 = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1 += 1;
            } else if (nums[i] == candidate2) {
                count2 += 1;
            } else if (count1 == 0) {
                candidate1 = nums[i];
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums[i];
                count2 = 1;
            } else {
                count1 -= 1;
                count2 -= 1;
            }
        }

        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == candidate1) {
                count1 += 1;
            }
            if (nums[i] == candidate2) {
                count2 += 1;
            }
        }

        if (count1 > nums.length / 3) {
            ret.add(candidate1);
        }
        if (count2 > nums.length / 3 && candidate1 != candidate2) {
            ret.add(candidate2);
        }
        return ret;
    }
}
