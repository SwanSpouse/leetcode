package dynamic_programing;

import utils.Print;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>();
        }
        int[] dp = new int[nums.length];
        int[] pre = new int[nums.length];
        dp[0] = 1;
        pre[0] = -1;
        Arrays.sort(nums);

        int max = 0, maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            pre[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    pre[i] = j;
                }
                if (dp[i] > max) {
                    max = dp[i];
                    maxIndex = i;
                }
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while (maxIndex != -1) {
            ret.add(nums[maxIndex]);
            maxIndex = pre[maxIndex];
        }
        Collections.sort(ret);
        return ret;
    }

    public static void main(String[] args) {
        Print.PrintList(new LargestDivisibleSubset().largestDivisibleSubset(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}
