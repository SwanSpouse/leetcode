package dfs;


public class HouseRobberII {

    /**
     * 房子如图：
     * A B C D E F G H I
     * T                 J
     * S R Q P O N M L k
     * <p>
     * 这道题用HouseRobber的思想：
     * 如果抢了A，那么B T不能抢，剩下的房子随便: C D E F G H I J K L M N O P Q R S
     * 如果不抢A，那么剩下的房子随便： B C D E F G H I J K L M N O P Q R S T
     * <p>
     * 所以比较抢了A的HouseRobberI 和 不抢A的HouseRobberI就好了。
     */


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robsub(nums, 0, nums.length - 2), robsub(nums, 1, nums.length - 1));
    }

    private int robsub(int[] nums, int s, int e) {
        int n = e - s + 1;
        int[] d = new int[n];
        d[0] = nums[s];
        d[1] = Math.max(nums[s], nums[s + 1]);

        for (int i = 2; i < n; i++) {
            d[i] = Math.max(d[i - 2] + nums[s + i], d[i - 1]);
        }
        return d[n - 1];
    }


    public static void main(String[] args) {
        System.out.println(new HouseRobberII().rob(new int[]{4, 3, 5, 6, 1, 2, 0, 4, 2, 5}));
    }
}
