package detail;

import java.util.HashMap;
import java.util.HashSet;

class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i =0; i < arr.length; i ++) {
            if (!count.containsKey(arr[i])) {
                count.put(arr[i], 0);
            }
            count.put(arr[i], count.get(arr[i])+1);
        }

        HashSet<Integer> set = new HashSet<>();
        for(Integer key : count.keySet()) {
            if (set.contains(count.get(key))) {
                return false;
            }
            set.add(count.get(key));
        }
        return true;
    }
}