package dfs;

/**
 *   一开始就想到用dfs的方法来求解，发现超时了。
 *   这道题应该是贪心算法。
 *     e.g. 
 *   0  1  2  3  4 
 *   2, 3, 1, 1, 4
 *   从0位置开始，可以跳2步，覆盖范围是1~2, 因为1的值是3，2的值是1，所以通过0位置的覆盖范围，可以确定0下一步要选1，因为1能够覆盖的范围到4，2位置覆盖的范围到3.
 *
 *   贪心的思想感觉就是在dfs的基础之上再思考一点点就好了。属于一个dfs的特殊解法似的。
 */
class JumpGame {
    // 超时了。
    public static boolean dfs(int[] nums, int curPos) {
        if(curPos == nums.length || curPos + nums[curPos] >= nums.length - 1) {
            return true;
        }
        for(int i=nums[curPos]; i >= 1; i -- ) {
            if(dfs(nums, curPos + i)) {
                return true;
            }
        }
        return false;
    }

    public static int jump(int[]nums, int curPos) {
        int maxArea = 0;
        int nextPos = curPos;
        for(int i=curPos; i < nums.length && i <= curPos + nums[curPos]; i ++ ) {
            if(nums[i] + i > maxArea) {
                maxArea = nums[i] + i;
                nextPos = i;
            }
        }
        return nextPos;
    }

    // 贪心算法
    public static boolean canJump(int[] nums) {
        int curPos = 0; 
        int nextPos = 0;
        do {
            curPos = nextPos;
            nextPos = jump(nums, curPos);
            if(nums[nextPos] + nextPos >= nums.length - 1) {
                return true;
            }
        } while(curPos != nextPos);
        return false;
    }
}