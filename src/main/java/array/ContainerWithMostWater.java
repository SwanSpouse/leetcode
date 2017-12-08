package array;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int max = 0;
        for (int i = 0, j = height.length - 1; i <= j; ) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            max = curArea > max ? curArea : max;
            if (height[i] == Math.min(height[i], height[j])) {
                i++;
            } else {
                j--;
            }
        }
        return max;
    }


    public static void main(String[] args) {
//        System.out.println(maxArea(new int[]{3, 5, 1, 4, 2}));
        System.out.println(maxArea(new int[]{5, 4, 3, 2, 1}));
    }
}
