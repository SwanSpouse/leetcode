package sort_and_search;

public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 左边有序，且在左边
            if (nums[left] <= nums[mid] && nums[left] <= target && target < nums[mid]) {
                right = mid - 1;
            }
            // 右边有序，且在右边
            if (nums[mid] <= nums[right] && nums[mid] < target && target <= nums[right]) {
                left = mid + 1;
            }
            // 左边有序，且不在左边
            if (nums[left] <= nums[mid] && !(nums[left] <= target && target < nums[mid])) {
                left = mid + 1;
            }
            // 右边有序，且不在右边
            if (nums[mid] <= nums[right] && !(nums[mid] < target && target <= nums[right])) {
                right = mid - 1;
            }
        }
        return (nums.length == 0 || nums[left] != target) ? -1 : left;
    }
}
