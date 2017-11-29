package array;

public class MedianOfTwoSortedArrays {

    public static int min(int num1, int num2) {
        return num1 < num2 ? num1 : num2;
    }

    public static double findKthNum(int[] nums1, int[] nums2, int k, int pos1, int pos2) {
        if (nums1.length == 0) {
            return nums2[k - 1];
        } else if (nums2.length == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return min(nums1[0], nums2[0]);
        }
        int mid1 = nums1.length / 2 - 1 > 0 ? nums1.length - 1 : 0;
        int mid2 = nums2.length / 2 - 1 > 0 ? nums2.length - 1 : 0;

        if (nums1[mid1] >= nums2[mid2]) {

        }
        return 0.0;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0 && nums2.length == 0) {
            return 0.0;
        }
        if ((nums1.length + nums2.length) % 2 == 1) {
            return findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1, 0, 0);
        }
        return (findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2, 0, 0) +
                findKthNum(nums1, nums2, (nums1.length + nums2.length) / 2 + 1, 0, 0)) / 2;
    }

    public static void main(String args[]) {
        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {2, 4, 6, 8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
