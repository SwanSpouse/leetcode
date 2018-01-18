package dfs;

import java.util.*;

/**
 *  和上一题类似，初步的想法是用两个map来记录次数，一个是出现的总次数，一个是当前出现的次数。
 * 同时还是用了uniqueCandidates首先对所有的candidates进行了一次去重。算是比较麻烦的。可能去重这个逻辑上，还有其他更好的办法。
 */
class CombinationSumII {

    public static void dfs(List<List<Integer>> ret, ArrayList<Integer> cur, int curSum, int target, ArrayList<Integer> candidates, int curIndex,
                                HashMap<Integer, Integer> totalCount, HashMap<Integer, Integer> curCount) {
        if( curSum == target) {
            ret.add(new ArrayList<Integer>(cur));
            return ;
        }
        for(int i = curIndex; i < candidates.size(); i ++ ) {
            int item = candidates.get(i);
            if(item + curSum > target ) {
                continue;
            }
            if(curCount.get(item) < totalCount.get(item)) {
                cur.add(item);
                curCount.put(item, curCount.get(item) + 1);
                dfs(ret, cur, curSum + item, target, candidates, i, totalCount, curCount);
                cur.remove(cur.size()-1);               
                curCount.put(item, curCount.get(item) - 1);
            }

        }
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>>ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();

        HashMap<Integer, Integer> totalCount = new  HashMap<Integer, Integer>();
        HashMap<Integer, Integer> curCount = new  HashMap<Integer, Integer>();
        ArrayList<Integer> uniqueCandidate = new ArrayList<Integer>();

        for(Integer candidate : candidates ) {
            curCount.put(candidate, 0);
            if( totalCount.containsKey(candidate)) {
                totalCount.put(candidate, totalCount.get(candidate) + 1);
            } else {
                totalCount.put(candidate, 1);
                uniqueCandidate.add(candidate);
            }
        }

        dfs(ret, cur, 0, target, uniqueCandidate, 0, totalCount, curCount);
        return ret;
    }
}