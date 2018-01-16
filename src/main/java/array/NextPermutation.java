package array;

import java.util.Arrays;

/**
 * 找规律题:
 *       1. 如果整体是逆序的。则把数组排序。
 *          e.g. 4,3,2,1 -> 1,2,3,4
 *       2. 如果数组的后两位是升序的，则把后两位逆序即可。
 *          e.g. 1,2,3,4 -> 1,2,4,3
 *               2,3,1,4 -> 2,3,4,1
 *       3. 否则，从后向前找到比最后一个数字小的数，把最后一个数字放到那里，然后后面的数字排序
 *          e.g. 1,4,3,2 -> 2,1,3,4   从后向前找，2比1小，然后2放到1的位置，后面排序。
 *
 *       其中第3个逻辑是有问题的。e.g. 2,3,4,1 -> 2,4,1,3 如果按照上面的逻辑应该是1,2,3,4
 *
 *       3. 正确的逻辑应该是这样的。找到第一个打破从后向前升序的点。然后把后面的点进行排序。在从后面的点中找到第一个比打破升序点大的点。（一定有）
 *    然后把这两个点的位置进行交换。
 *       ps: 这里又少考虑了一种相等的情况。相等不算打破升序。
 */
class NextPermutation {
    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    public static void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int last = nums.length - 1;
        if (nums[last] > nums[last - 1]) {
            swap(nums, last, last - 1);
        } else {
            int firstBreakOrder = last - 1;
            while (firstBreakOrder >= 0 && nums[firstBreakOrder] >= nums[firstBreakOrder + 1]) {
                firstBreakOrder -= 1;
            }
            if (firstBreakOrder == -1) {
                Arrays.sort(nums);
            } else {
                Arrays.sort(nums, firstBreakOrder + 1, last + 1);
                int target = firstBreakOrder + 1;
                while (nums[target] <= nums[firstBreakOrder]) {
                    target += 1;
                }
                swap(nums, firstBreakOrder, target);
            }
        }
    }

    public static void main(String[] args) {
//        int[] ret = new int[]{1, 1, 5};
        int[] ret = new int[]{4, 3, 2, 1};
        for (int i = 0; i < 20; i++) {
            nextPermutation(ret);
            for (int item : ret) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}