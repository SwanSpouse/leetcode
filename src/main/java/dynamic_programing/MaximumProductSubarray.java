package dynamic_programing;

public class MaximumProductSubarray {

    //    public int maxProduct(int[] nums) {
//        int maxVal = Integer.MIN_VALUE;
//        for (int start = 0; start < nums.length; start++) {
//            int temp = 0;
//            for (int end = start; end < nums.length; end++) {
//                if (start == end) {
//                    temp = nums[start];
//                } else {
//                    temp *= nums[end];
//                }
//                maxVal = maxVal < temp ? temp : maxVal;
//            }
//        }
//        return maxVal;
//    }

    public int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int maxProduct(int[] nums) {
        int ret = Integer.MIN_VALUE;

        int[] maxArr = new int[nums.length];
        int[] minArr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                maxArr[i] = nums[0];
                minArr[i] = nums[0];
            } else {
                maxArr[i] = max(maxArr[i - 1] * nums[i], nums[i], minArr[i - 1] * nums[i]);
                minArr[i] = min(minArr[i - 1] * nums[i], nums[i], maxArr[i - 1] * nums[i]);
            }
            ret = Math.max(maxArr[i], ret);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{1, -2, 3, -4, 5, 6}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{1, -2, 3, -4, 5, -6}));
        System.out.println(new MaximumProductSubarray().maxProduct(new int[]{-2}));
    }
}
