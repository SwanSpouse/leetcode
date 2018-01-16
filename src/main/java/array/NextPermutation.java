package array;

/**
 * 找规律题: 
 * 		1. 如果整体是逆序的。则把数组排序。
 *          e.g. 4,3,2,1 -> 1,2,3,4
 *		2. 如果数组的后两位是升序的，则把后两位逆序即可。
 *  		e.g. 1,2,3,4 -> 1,2,4,3
 *		 		 2,3,1,4 -> 2,3,4,1
 *		3. 否则，从后向前找到比最后一个数字小的数，把最后一个数字放到那里，然后后面的数字排序
 *			e.g. 1,4,3,2 -> 2,1,3,4   从后向前找，2比1小，然后2放到1的位置，后面排序。
 */ 
class NextPermutation {
	public static void swap(int[] nums, int x, int y) {
		int temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}

	public static void nextPermutation(int[] nums) {
        if(nums.length <= 1) {
        	return;
        }
        int last = nums.length -1;
        if (nums[last] > nums[last-1]) {
        	swap(nums, last, last-1);
        } else {
        	int fisrtMinThanLast = last-1;
        	while(fisrtMinThanLast >=0 && nums[fisrtMinThanLast] > nums[last]) {
        		fisrtMinThanLast -= 1;
        	}
        	if (fisrtMinThanLast == -1) {
        		Arrays.sort(nums);
        	} else {
        		swap(nums, fisrtMinThanLast, last);
        		Arrays.sort(nums, fisrtMinThanLast +1, last)
        	}
        }
    }
}