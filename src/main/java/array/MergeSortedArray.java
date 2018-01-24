package array;

/**
 * 	数组的题正向没有比较好的方法可以逆向看看。
 */ 
class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m + n - 1;
		m = m -1;
		n = n -1;
    	while(m >= 0 || n >= 0) {
    		int value1  = m >=0 ? nums1[m] : Integer.MIN_VALUE;
    		int value2  = n >=0 ? nums2[n] : Integer.MIN_VALUE;
    		if( value1 >= value2 )  {
    			nums1[index -- ] = value1;
    			m -= 1;
    		} else {
    			nums1[index -- ] = value2;
    			n -= 1;
    		}
    	}
    }
}