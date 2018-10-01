package array;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            if (map1.containsKey(num)) {
                map1.put(num, map1.get(num) + 1);
            } else {
                map1.put(num, 1);
            }
        }
        HashMap<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int num : nums2) {
            if (map2.containsKey(num)) {
                map2.put(num, map2.get(num) + 1);
            } else {
                map2.put(num, 1);
            }
        }
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for (Integer num : map1.keySet()) {
            if (map2.containsKey(num)) {
                for (int i = 0; i < Math.min(map1.get(num), map2.get(num)); i++) {
                    arr.add(num);
                }
            }
        }
        int[] ret = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            ret[i] = arr.get(i);
        }
        return ret;
    }
}
