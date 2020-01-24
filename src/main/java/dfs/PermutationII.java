package dfs;

import java.util.*;

/**
 * 使用HashMap技术的方法来做的。比较复杂，占用了很多空间复杂度。找个地方还可以优化。
 */
class PermutationsII {
    public static void dfs(List<List<Integer>> ret, List<Integer> cur, int[] nums, HashMap<Integer,Integer>originCount, HashMap<Integer, Integer>curCount){
        if( cur.size() == nums.length){
            ret.add(new ArrayList<Integer>(cur));
            return ;
        }

        for(Integer key : originCount.keySet()) {
            if(curCount.get(key) >= originCount.get(key)) {
                continue;
            }
            cur.add(key);
            curCount.put(key, curCount.get(key) + 1);
            dfs(ret, cur, nums, originCount, curCount);
            cur.remove(cur.size()-1);
            curCount.put(key, curCount.get(key) - 1);
        }
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        HashMap<Integer,Integer> originCount = new HashMap<Integer, Integer>();
        HashMap<Integer,Integer> curCount = new HashMap<Integer, Integer>();

        for(int i=0; i < nums.length; i ++ ) {
            if(originCount.containsKey(nums[i])){
                originCount.put(nums[i], originCount.get(nums[i])+1);
            }else{
                originCount.put(nums[i], 1);
                curCount.put(nums[i], 0);
            }
        }
        dfs(ret, cur, nums, originCount, curCount);
        return ret;        
    }
}