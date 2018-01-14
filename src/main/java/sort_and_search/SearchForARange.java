package sort_and_search;

/**
 *
 * 这道题最直观的解法就是二分查找，找到其中一个值，然后向两边扩展。我记得这个解法超时了。
 * 现在的思路是两次二分查找。一个查找上界，一个查找下界。这个思路是对的。如果再优化的是不是就要看一次二分是不是可以把两部分都搞定。
 */
class SearchForARange {

    public static int binarySearch(int[] nums, int target, boolean findLeft) {
        if( nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length -1;
        int ret = -1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ret = mid ;
                right = findLeft ? mid -1 : right;
                left  = findLeft ? left : mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return ret;
    }

    public static int[] searchRange(int[] nums, int target) {
        int [] ret = new int[] {-1, -1};
        if (nums.length == 0) {
            return ret;
        }
        ret[0] = binarySearch(nums, target, true);
        ret[1] = binarySearch(nums, target, false);
        return ret;
    }

    public static void main(String[] args) {
        int[] ret = searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
        for (int i=0; i < ret.length ; i ++ ) {
            System.out.println(i + " " + ret[i]);
        }
    }
} 