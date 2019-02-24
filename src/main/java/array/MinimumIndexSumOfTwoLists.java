package array;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> index = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            index.put(list1[i], i);
        }

        HashMap<String, Integer> common = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        for (int i = 0; i < list2.length; i++) {
            if (index.containsKey(list2[i]) && index.get(list2[i]) + i <= minIndex) {
                minIndex = index.get(list2[i]) + i;
                common.put(list2[i], minIndex);
            }
        }

        ArrayList<String> ret = new ArrayList<>();
        for (String key : common.keySet()) {
            if (common.get(key) == minIndex) {
                ret.add(key);
            }
        }
        String[] r = new String[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            r[i] = ret.get(i);
        }
        return r;
    }
}
