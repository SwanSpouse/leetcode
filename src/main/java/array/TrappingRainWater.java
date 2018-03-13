package array;

/**
 * 这种数组的题，肯定是从两边往中间靠的方法。不然就超时了。
 */
class TrappingRainWater {

    public static int trap(int[] height) {
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int len = height.length;

        for (int i = 1; i < len - 1; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
            maxRight[len - 1 - i] = Math.max(height[len - i], maxRight[len - i]);
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            int curHeight = Math.min(maxLeft[i], maxRight[i]);
            if (curHeight > height[i]) {
                sum += curHeight - height[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{1, 1, 2, 3, 2, 1, 1}));
        System.out.println(trap(new int[]{3, 3, 2, 1, 2, 3, 1}));
        System.out.println(trap(new int[]{3, 1, 5, 1, 3}));
        System.out.println(trap(new int[]{5, 4, 1, 2}));
    }
}