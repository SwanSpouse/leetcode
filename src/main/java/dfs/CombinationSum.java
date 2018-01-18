package dfs;

import java.util.*;

/**
 * 典型的dfs，这道题的难点在于怎么进行剪枝和去重。其实这也是所有dfs问题的难点。
 * 
 * 这道题的方法：
 *      查找：每个候选数组中的数字都有选中和被选中两种可能。
 *      剪枝：1. 只能从候选数组的当前位置及以后的位置进行选择。 
 *           2. 一旦加上候选数组中第i个数字大于了target，则不比再往大了遍历了。
 */
class CombinationSum {

    public static void dfs(List<List<Integer>> ret, ArrayList<Integer> cur, int curSum, int[] candidates, int target, int curIndex) {
        if( curSum == target) {
            ret.add(new ArrayList<Integer>(cur));
            return ;
        }

        for(int i= curIndex; i < candidates.length; i ++ ) {
            if(curSum + candidates[i]  > target) {
                continue  ;
            } else {
                cur.add(candidates[i]);
                dfs(ret, cur, curSum + candidates[i], candidates, target, i);
                cur.remove(cur.size()-1);
            }
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>>ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(ret, cur, 0, candidates, target, 0);
        return ret;
    }
}