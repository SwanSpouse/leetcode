package array;

import utils.Print;

import java.util.ArrayList;

/**
 * 这种数组的题，肯定是从两边往中间靠的方法。不然就超时了。
 */
class TrappingRainWater {

    public static int getWater(int[] height, int leftPeek, int rightPeek) {
        int min = height[leftPeek] < height[rightPeek] ? height[leftPeek] : height[rightPeek];
        int ret = min * (rightPeek - leftPeek - 1);
        for (int i = leftPeek + 1; i < rightPeek; i++) {
            if (height[i] > min) {
                ret = ret - min;
            } else {
                ret = ret - height[i];
            }
        }
        System.out.println("left " + leftPeek + " right " + rightPeek + " value " + ret);
        return ret;
    }

    public static int trap(int[] height) {
        if (height.length <= 2) {
            return 0;
        }
        ArrayList<Integer> peeks = new ArrayList<Integer>();
        for (int i = 0; i < height.length; i++) {
            if (i == 0) {
                if (height[i] > height[i + 1]) {
                    peeks.add(i);
                }
            } else if (i == height.length - 1) {
                if (height[i] > height[i - 1]) {
                    peeks.add(i);
                }
            } else if (height[i] > height[i - 1] && height[i] > height[i + 1]) {
                peeks.add(i);
            } else if (height[i] == height[i - 1] && height[i] > height[i + 1]) {
                peeks.add(i);
            } else if (height[i] > height[i - 1] && height[i] == height[i + 1]) {
                peeks.add(i);
            }
        }
        Print.PrintList(peeks);
        if (peeks.size() < 2) {
            return 0;
        }
        int ret = 0;
        for (int i = 0; i < peeks.size() - 1; i++) {
            ret += getWater(height, peeks.get(i), peeks.get(i + 1));
        }
        return ret;
    }

    public static void main(String[] args) {
/*        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        System.out.println(trap(new int[]{1, 1, 2, 3, 2, 1, 1}));
        System.out.println(trap(new int[]{3, 3, 2, 1, 2, 3, 1}));
        System.out.println(trap(new int[]{3, 1, 5, 1, 3}));*/
        System.out.println(trap(new int[]{5, 4, 1, 2}));
    }
}