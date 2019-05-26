package array;

import java.util.Arrays;

public class HeightChecker {
    public int heightChecker(int[] heights) {
        int[] origin = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(heights);
        int ret = 0;
        for (int i = 0; i < origin.length; i++) {
            if (heights[i] != origin[i]) {
                ret += 1;
            }
        }
        return ret;
    }
}
