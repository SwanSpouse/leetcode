package dfs;

import java.util.*;

/**
 *  这道题使用了HashSet来进行去重。是不是有点儿投机取巧了。这里应该有更简单的办法来进行操作。
 */
class Permutations {

    public static void dfs(List<List<Integer>> ret, List<Integer> cur, int[] nums, HashSet<Integer> curSet) {
        if( cur.size() == nums.length){
            ret.add(new ArrayList(cur));
            return ;
        }
        for(int i=0; i < nums.length; i ++) {
            if(curSet.contains(nums[i])) {
                continue;
            }
            cur.add(nums[i]);
            curSet.add(nums[i]);
            dfs(ret, cur, nums, curSet);
            cur.remove(cur.size()-1);
            curSet.remove(nums[i]);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        HashSet<Integer> curSet = new HashSet<Integer>();
        dfs(ret, cur, nums, curSet);
        return ret;        
    }
}