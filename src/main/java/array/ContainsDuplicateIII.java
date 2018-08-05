package array;

import java.util.TreeSet;

public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if ((set.floor(nums[i]) != null && nums[i] <= t + set.floor(nums[i])) || (set.ceiling(nums[i]) != null && set.ceiling(nums[i]) <= t + nums[i]))
                return true;
            set.add(nums[i]);
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }


    public static void main(String[] args) {
//        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 5, 9, 1, 5, 9}, 2, 3));
//        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 0, 1, 1}, 1, 2));
//        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{1, 2, 3, 1}, 3, 0));
        System.out.println(new ContainsDuplicateIII().containsNearbyAlmostDuplicate(new int[]{-2147483648, -2147483647}, 3, 3));
    }
}
