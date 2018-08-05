package dfs;

import utils.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {

    public void dfs(List<List<Integer>> ret, List<Integer> cur, Set<Integer> curSet, int sum, int lowerBound, int k, int target) {
        if (sum == target && cur.size() == k) {
            ret.add(new ArrayList<Integer>(cur));
            return;
        }
        if (sum > target || cur.size() > k) {
            return;
        }
        for (int i = lowerBound + 1; i <= 9; i++) {
            if (curSet.contains(i)) {
                continue;
            }
            curSet.add(i);
            cur.add(i);
            dfs(ret, cur, curSet, sum + i, i, k, target);
            curSet.remove(i);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        dfs(ret, cur, set, 0, 0, k, n);
        return ret;
    }

    public static void main(String[] args) {
        Print.Print2DIntegerList(new CombinationSumIII().combinationSum3(3, 12));
    }
}
