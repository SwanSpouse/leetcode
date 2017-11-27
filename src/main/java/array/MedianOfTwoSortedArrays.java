package array;

public class MedianOfTwoSortedArrays {

    public static int min(int num1, int num2) {
        return num1 < num2 ? num1 : num2;
    }

    public static double findKthNum(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k - 1];
        } else if (nums2.length == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return min(nums1[0], nums2[0]);
        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1);
        }
        return (findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2) +
                findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) / 2;
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
