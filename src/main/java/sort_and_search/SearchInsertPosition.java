package sort_and_search;

/**
 *  二分查找的简单变型。
 *  需要特殊处理的就是如果target大于数组内所有元素的时候。
 */
class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left  = mid + 1;
            }
        }
        if (nums.length != 0 && nums[left] < target) {
            return left + 1;
        }
        return left;
    }
}