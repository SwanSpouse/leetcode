package array;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length == 0) {
            return true;
        }
        int recorderCount = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                if (i + 1 < nums.length && i - 1 >= 0 && nums[i + 1] - nums[i - 1] == 1) {
                    return false;
                }
                recorderCount += 1;
            }
        }
        return recorderCount <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{4, 2, 3}));
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{2, 4, 3}));
    }
}
