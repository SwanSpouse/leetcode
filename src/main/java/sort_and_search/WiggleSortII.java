package sort_and_search;

import utils.Print;

import java.util.Arrays;

// 最优解法要求O(n)时间复杂度，O(1)空间复杂度
public class WiggleSortII {

    public void wiggleSort(int[] nums) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        Arrays.sort(temp);

        int mid = (nums.length + 1) / 2;
        int j = 0;
        for (int right = temp.length - 1, left = mid - 1; left >= 0; left--, right--) {
            nums[j++] = temp[left];
            if (right >= mid) {
                nums[j++] = temp[right];
            }
        }
        Print.PrintArr(nums);
    }

    public static void main(String[] args) {
        new WiggleSortII().wiggleSort(new int[]{1, 3, 2, 2, 3, 1});
        new WiggleSortII().wiggleSort(new int[]{1, 5, 1, 1, 6});
        new WiggleSortII().wiggleSort(new int[]{4, 5, 5, 6});
    }
}
