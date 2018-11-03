package dynamic_programing;

public class IncreasingTripletSubsequence {

//    public boolean increasingTriplet(int[] nums) {
//        if (nums.length < 3) {
//            return false;
//        }
//        int[] dp = new int[nums.length];
//        dp[0] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = 1;
//            for (int j = 0; j < i; j++) {
//                dp[i] = nums[i] > nums[j] ? Math.max(dp[i], dp[j] + 1) : dp[i];
//                if (dp[i] >= 3) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }
        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            } else if (nums[i] <= secondMin) {
                secondMin = nums[i];
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        System.out.println(new IncreasingTripletSubsequence().increasingTriplet(new int[]{1, 2, -10, -8, -7}));
    }
}
