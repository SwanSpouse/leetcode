package array;

import java.lang.Math;
import java.util.*;

/**
*	这里面有个问题是这个closet的初始值。这个如果设置成最大会有问题啊。TODO lmj
*/

class ThreeSumCloest {

    public int threeSumClosest(int[] nums, int target) {
    	Arrays.sort(nums);
        // int closet = Integer.MAX_VALUE;
        int closet = 1000;

        for(int start=0; start < nums.length; start ++ ) {
        	int left = start + 1;
        	int right = nums.length -1;
        	while(left < right) {
        		int cur = nums[start] + nums[left] + nums[right];
        		if ( cur == target) {
        			return target;
        		}
        		closet = Math.abs(target - cur) < Math.abs(target - closet) ? cur : closet;
        		if(cur <= target) {
        			left += 1;
        		} else {
        			right -= 1;
        		}
        	}
        }
        return closet;
    }
}
