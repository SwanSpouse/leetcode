package array_test;

import org.junit.Test;

import static array.MedianOfTwoSortedArrays.findMedianSortedArrays;
import static org.junit.Assert.assertEquals;

public class TestMediaOfTwoSortedArrays {
    @Test
    public void testFindMedianSortedArrays() {
        int[] nums2 = {1, 2, 3, 4};
        int[] nums1 = {1, 2, 3, 4};
        assertEquals(null, findMedianSortedArrays(nums1, nums2), 2.5, 0.0);

        int[] nums3 = {1, 3, 5, 7, 9};
        int[] nums4 = {2, 4, 6, 8};
        assertEquals("",findMedianSortedArrays(nums3, nums4), 5, 0.0);

        assertEquals("",findMedianSortedArrays(new int[]{1, 3, 5, 7, 9}, new int[]{}), 5, 0.0);
    }
}
