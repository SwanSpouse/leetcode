package dfs;

import java.util.*;

/**
 * 典型的dfs，这道题的难点在于怎么进行剪枝和去重。其实这也是所有dfs问题的难点。
 */
class CombinationSum {

    public static void dfs(List<List<Integer>> ret, ArrayList<Integer> cur, int curSum, int[] candidates, int target) {
        if( curSum == target) {
            ret.add(new ArrayList<Integer>(cur));
            return ;
        }

        for(int i=0; i < candidates.length; i ++ ) {
            if(curSum + candidates[i]  > target) {
                continue ;
            } else {
                cur.add(candidates[i]);
                dfs(ret, cur, curSum + candidates[i], candidates, target);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>>ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(ret, cur, candidates, target);
        return ret;
    }
}