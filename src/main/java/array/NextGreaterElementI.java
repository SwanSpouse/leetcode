package array;

import java.util.*;


public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> index = new HashMap<>();
        for(int i=0; i < nums2.length; i ++ ) {
            index.put(nums2[i], i);
        }

        int[] ret = new int[nums1.length];
        for(int i =0; i < nums1.length; i ++ ) {
            ret[i] = -1;
            for(int cur = index.get(nums1[i]) + 1; cur < nums2.length; cur ++) {
                if(nums2[cur] > nums1[i]) {
                    ret[i] = nums2[cur];
                    break;
                }
            }
        }
        return ret;
    }
}
