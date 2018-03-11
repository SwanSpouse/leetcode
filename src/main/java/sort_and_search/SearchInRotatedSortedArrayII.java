package sort_and_search;

/**
 * 当二分的时候，nums[left]==nums[mid]==nums[target]的时候，就没有办法使用SearchInRotatedSortedArray一样方法了。
 * <p>
 * 所以需要对上面所说的特殊情况作出处理。遇到这种情况只需要left += 1
 */
public class SearchInRotatedSortedArrayII {

    public static boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right && left >=0 && right < nums.length) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // 如果无法判断哪段有序或者无序，则left ++
            if (nums[mid] == nums[left] && nums[left] == nums[right]) {
                left += 1;
                continue;
            }
            // 左侧有序，且在左侧
            if (nums[mid] >= nums[left] && nums[mid] >= target && target >= nums[left]) {
                right = mid - 1;
            }
            // 左侧有序，但不在左侧
            if (nums[mid] >= nums[left] && !(nums[mid] >= target && target >= nums[left])) {
                left = mid + 1;
            }
            // 右侧有序，且在右侧
            if (nums[mid] <= nums[right] && nums[mid] <= target && target <= nums[right]) {
                left = mid + 1;
            }
            // 右侧有序，但不在右侧
            if (nums[mid] <= nums[right] && !(nums[mid] <= target && target <= nums[right])) {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        System.out.println(search(new int[]{4, 3, 4, 4, 4, 4}, 3));
        System.out.println(search(new int[]{1}, 0));
    }
}
