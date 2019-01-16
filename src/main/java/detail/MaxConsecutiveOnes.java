package detail;

public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max =0, cur=0;
        for(int i =0; i < nums.length; i ++ ) {
            if(nums[i] == 0) {
                max = Math.max(max, cur);
                cur = 0;
            } else {
                cur += 1;
            }
        }
        max = Math.max(max, cur);
        return max;
    }
}
