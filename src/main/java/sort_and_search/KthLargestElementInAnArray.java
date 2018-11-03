package sort_and_search;

public class KthLargestElementInAnArray {

    public int findKthLargestElement(int[] nums, int k, int left, int right) {
        if (left == right && k == 1) {
            return nums[left];
        }
        int start = left, end = right;
        int sentinel = nums[left];

        while (start < end) {
            while (start < end && nums[end] > sentinel) {
                end -= 1;
            }
            nums[start] = nums[end];
            while (start < end && nums[start] < sentinel) {
                start += 1;
            }
            nums[end] = nums[start];
        }
        nums[start] = sentinel;

        if (k == right - start + 1) {
            return nums[start];
        } else if (k < right - start + 1) {
            return findKthLargestElement(nums, k, start + 1, right);
        } else {
            return findKthLargestElement(nums, k - (right - start + 1), left, start - 1);
        }
    }

    public int findKthLargest(int[] nums, int k) {
        int ret = findKthLargestElement(nums, k, 0, nums.length - 1);
        return ret;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 6; i++) {
            System.out.println(new KthLargestElementInAnArray().findKthLargest(new int[]{3, 1, 2, 5, 6, 4}, i));
        }
    }
}
