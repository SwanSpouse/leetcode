package array;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> retSet = new HashSet<Integer>();
        for (int num : nums2) {
            if (set.contains(num)) {
                retSet.add(num);
            }
        }
        int[] ret = new int[retSet.size()];
        int i = 0;
        for (int num : retSet) {
            ret[i++] = num;
        }
        return ret;
    }
}
