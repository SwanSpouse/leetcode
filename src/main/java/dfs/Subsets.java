
package dfs;

import java.util.*;


public class Subsets {

    public static void dfs(List<List<Integer>>ret, List<Integer>cur, int[]nums, int pos) {
        if (pos >= nums.length) {
            ret.add(new ArrayList<Integer>(cur));
            return ;
        }
        dfs(ret, cur, nums, pos + 1);
        cur.add(nums[pos]);
        dfs(ret, cur, nums, pos + 1);
        cur.remove(cur.size()-1);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> cur =new ArrayList<Integer>();
        dfs(ret, cur, nums, 0);
        return ret;
    }
}
