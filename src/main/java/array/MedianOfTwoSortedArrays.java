package array;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {

    public static int min(int num1, int num2) {
        return num1 < num2 ? num1 : num2;
    }


    public static double findKthNum(int[] nums1, int[] nums2, int k) {
        if (nums1.length == 0) {
            return nums2[k - 1];
        }
        if (nums2.length == 0) {
            return nums1[k - 1];
        }
        if (k == 1) {
            return min(nums1[0], nums2[0]);
        }
        int mid1 = k / 2 - 1 >= nums1.length ? nums1.length - 1 : k / 2 - 1;
        int mid2 = k / 2 - 1 >= nums2.length ? nums2.length - 1 : k / 2 - 1;

        if (nums2[mid2] > nums1[mid1]) {
            int[] nums1New = mid1 == nums1.length - 1 ? new int[]{} : Arrays.copyOfRange(nums1, mid1 + 1, nums1.length);
            k = k - mid1 - 1;
            return findKthNum(nums1New, nums2, k);
        } else {
            int[] nums2New = mid2 == nums2.length - 1 ? new int[]{} : Arrays.copyOfRange(nums2, mid2 + 1, nums2.length);
            k = k - mid2 - 1;
            return findKthNum(nums1, nums2New, k);
        }
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
//        int[] nums1 = {1, 3, 5, 7, 9};
//        int[] nums2 = {2, 4, 6, 8};
//        System.out.println(findMedianSortedArrays(nums1, nums2));

        int[] nums2 = {1, 2, 3, 4};
        int[] nums1 = {1, 2, 3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
