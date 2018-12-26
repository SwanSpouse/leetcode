package array;

public class MinimumMovesToEqualArrayElements {
    public int minMoves(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int min = nums[0];
        for(int i = 1; i < nums.length; i ++) {
            min = Math.min(min, nums[i]);
        }

        int moves = 0;
        for(int i = 0; i < nums.length; i ++) {
            moves += nums[i] - min;
        }
        return moves;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumMovesToEqualArrayElements().minMoves(new int[]{1,2,3,4}));
    }
}
