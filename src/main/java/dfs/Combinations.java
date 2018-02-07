package dfs;

import java.util.*;

public class Combinations {

    public static void dfs(List<List<Integer>>ret, List<Integer>cur, int n, int k, int curPos ) {
        if(cur.size() == k){
            ret.add(new ArrayList<Integer>(cur));
            return ;
        }
        for(int i=curPos; i <=n; i ++ ) {
            cur.add(i);
            dfs(ret, cur, n, k, i +1 );
            cur.remove(cur.size()-1);
        }
    }


    public static List<List<Integer>> combine(int n, int k) {
        ArrayList<List<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        dfs(ret, cur, n, k, 1);
        return ret;
    }
}