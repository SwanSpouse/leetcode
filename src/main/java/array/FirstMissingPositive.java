package array;

import java.util.*;

/**
 * 这题看着没啥思路。最直观的感觉就是先排序。但是要求的时间复杂度是O(n)
 *
 *      依稀记得这道题会利用HashSet, 现在的想法是把里面所有的正数+0，放入Set中，
 * 然后遍历Set中的所有元素，查看Set中的元素的左边元素和右边元素(元素要>0)是否在Set，
 * 如果不在则记录下来，取所有不在Set中元素最下的那一个。但是要求的是空间复杂度是常数级别。
 *
 *      常数实现方式：利用桶排序的思想。根据自身的值，放到相应的位置上去。如果是6则放到5这个位置上。
 * 经过这样的操作之后，所有的元素都应该在自己的位置之上。如果不在，则表明这个位置上的元素缺失。
 */
class FirstMissingPositive {
    // 这个解法不是常数时间复杂度的。
    public static int firstMissingPositive2(int[] nums) {
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

    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] - 1 != i && 0 <= nums[i] - 1 && nums[i] - 1 < nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        int i;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{0, 1, 5, 6}));
        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(firstMissingPositive(new int[]{}));
        System.out.println(firstMissingPositive(new int[]{1}));
        System.out.println(firstMissingPositive(new int[]{2}));
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }
}