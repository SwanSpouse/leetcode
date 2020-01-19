package detail;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        int min = Integer.MAX_VALUE;
        for(int i =0; i < arr.length -1 ; i ++) {
            min = Math.min(min, arr[i+1]-arr[i]);
        }

        for(int i =0 ; i < arr.length; i ++ ) {
            for(int j = i +1; j < arr.length; j ++) {
                if(arr[j]-arr[i] != min) {
                    continue ;
                }
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(arr[i]);
                cur.add(arr[j]);
                ret.add(cur);
            }
        }
        return ret;
    }
}