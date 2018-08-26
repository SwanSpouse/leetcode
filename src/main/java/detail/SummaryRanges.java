package detail;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if (nums.length == 0) {
            return ret;
        }
        int beginIndex = 0;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last + 1) {
                if (nums[beginIndex] == last) {
                    ret.add(last + "");
                } else {
                    ret.add(nums[beginIndex] + "->" + last);
                }
                beginIndex = i;
            }
            last = nums[i];
        }
        if (beginIndex == nums.length - 1) {
            ret.add(nums[nums.length - 1] + "");
        } else {
            ret.add(nums[beginIndex] + "->" + nums[nums.length - 1]);
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.PrintList(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 7, 8}));
    }
}
