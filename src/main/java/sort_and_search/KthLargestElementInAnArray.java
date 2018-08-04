package sort_and_search;

public class KthLargestElementInAnArray {

    public void quickSort(int[] nums, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int sentinel = nums[begin];
        int left = begin;
        int right = end;
        while (left < right) {
            while (nums[right] >= sentinel && left < right) {
                right -= 1;
            }
            nums[left] = nums[right];
            while (nums[left] <= sentinel && left < right) {
                left += 1;
            }
            nums[right] = nums[left];
        }
        nums[left] = sentinel;
        quickSort(nums, begin, left - 1);
        quickSort(nums, left + 1, end);
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, 4));

//        for (int i = 1; i <= nums.length; i++) {
//            System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, i));
//        }
    }
}
