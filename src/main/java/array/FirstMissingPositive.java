package array;

import java.util.*;

/**
 * 这题看着没啥思路。最直观的感觉就是先排序。但是要求的时间复杂度是O(n)
 *
 *      依稀记得这道题会利用HashSet, 现在的想法是把里面所有的正数+0，放入Set中，
 * 然后遍历Set中的所有元素，查看Set中的元素的左边元素和右边元素(元素要>0)是否在Set，
 * 如果不在则记录下来，取所有不在Set中元素最下的那一个。但是要求的是空间复杂度是常数级别。
 */
class FirstMissingPositive {
    public static int firstMissingPositive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(0);
        for (Integer item : nums) {
            if (item > 0) {
                set.add(item);
            }
        }

        int ret = Integer.MAX_VALUE;
        for (Integer key : set) {
            ret = key - 1 > 0 && !set.contains(key - 1) && key - 1 < ret ? key - 1 : ret;
            ret = key + 1 > 0 && !set.contains(key + 1) && key + 1 < ret ? key + 1 : ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{0, 1, 5, 6}));
    }
}