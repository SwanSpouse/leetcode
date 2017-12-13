package array;

import java.util.*;

/**
*  记得当年做的时候去重用的是Set，现在利用逻辑（剪枝）来去重，比用Set更简洁一些，
*/

class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		if (nums.length < 3) {
			return ret;
		}
		Arrays.sort(nums);
		for(int start = 0; start < nums.length; start ++ ) {
			if(start != 0 && nums[start-1] == nums[start]) {
				continue;
			}
			int left  = start + 1;
			int right = nums.length - 1;
			while(left < right) {
				int curVal = nums[start] + nums[left] + nums[right];
				if(curVal == 0) {
					ArrayList<Integer> cur = new ArrayList<Integer>();
					cur.add(nums[start]);
					cur.add(nums[left]);
					cur.add(nums[right]);
					ret.add(cur);
				} 
				if ( curVal >= 0 ){
					right -= 1;
					while(left < right && nums[right] == nums[right+1]){
						right -= 1;
					}
				} 
				if (curVal < 0) {
					left += 1;
					while(left < right && nums[left-1] == nums[left]){
						left += 1;
					}
				}
			}
		}
        return ret;
    }
}