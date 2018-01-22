package dfs;

/**
 * 第一感觉和JumpGame这道题思路一样。都是贪心。然后多了一个变量记录步数。
 *
 * 这道题抽时间看看网上是怎么给出答案的。
 */
class JumpGameII {
    public static int jumpTo(int[] nums, int curPos) {
        int maxArea = 0;
        int nextPos = curPos;
        for (int i = curPos + 1; i < nums.length && i <= curPos + nums[curPos]; i++) {
            if (nums[i] + i > maxArea) {
                maxArea = nums[i] + i;
                nextPos = i;
            }
        }
        return nextPos;
    }

    public static int jump(int[] nums) {
        int curPos = 0;
        int stepCount = 0;
        while (curPos < nums.length - 1) {
            if (curPos + nums[curPos] >= nums.length - 1) {
                return stepCount + 1;
            }
            curPos = jumpTo(nums, curPos);
            stepCount += 1;
        }
        return stepCount;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
        System.out.println(jump(new int[]{2, 1}));
        System.out.println(jump(new int[]{1, 3}));
        System.out.println(jump(new int[]{0}));
        System.out.println(jump(new int[]{3, 2, 1}));
    }
}