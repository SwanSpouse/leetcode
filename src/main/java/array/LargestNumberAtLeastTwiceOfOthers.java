package array;

public class LargestNumberAtLeastTwiceOfOthers {
    // 这还可以优化成一次遍历，因为一次遍历就可以获取到最大的两个数。
    public int dominantIndex(int[] nums) {
        if(nums.length == 0) {
            return -1;
        }
        int max = nums[0], index = 0;
        for(int i =1; i < nums.length; i ++ ) {
            if(nums[i] >= max) {
                index = i;
                max = nums[i];
            }
        }
        int secondary = Integer.MIN_VALUE;
        for(int i =0; i < nums.length; i ++ ) {
            if( i != index && nums[i] > secondary) {
                secondary = nums[i];
            }
        }
        return nums[index] >= secondary * 2 ? index : -1;
    }
}
