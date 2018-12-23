package dfs;

import utils.Print;

import java.util.*;

public class SubsetsII {

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Set<List<Integer>> visited = new HashSet<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(nums);
        dfs(ret, visited, cur, nums, 0);
        return ret;
    }

    public static void dfs(List<List<Integer>> ret, Set<List<Integer>> visited, List<Integer> cur, int[] nums, int pos) {
        if (pos >= nums.length) {
            if (!visited.contains(cur)) {
                visited.add(new ArrayList<Integer>(cur));
                ret.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        dfs(ret, visited, cur, nums, pos + 1);
        cur.add(nums[pos]);
        dfs(ret, visited, cur, nums, pos + 1);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        Print.print2DIntegerList(subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }
}
