package sort_and_search;

public class FindMinimumInRotatedSortedArray {
    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (right - left == 1 || left == right) {
                return Math.min(nums[left], nums[right]);
            }
            int mid = (right - left) / 2 + left;
            // 左侧有序说明拐点在右侧
            // 右侧有序说明拐点在左侧
            if (nums[right] >= nums[mid] && nums[mid] >= nums[left]) {
                return nums[left];
            } else if (nums[mid] >= nums[left]) {
                left = mid;
            } else if (nums[right] >= nums[mid]) {
                right = mid;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 1, 2}));
        System.out.println(findMin(new int[]{1, 2, 3}));
        System.out.println(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(findMin(new int[]{3, 4, 5, 6, 7, 8, 1, 2}));
        System.out.println(findMin(new int[]{1, 2, 3, 4, 5, 6, 7, 8}));
    }
}
