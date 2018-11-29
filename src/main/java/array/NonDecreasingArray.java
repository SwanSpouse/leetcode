package array;

public class NonDecreasingArray {
    public boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for (int i = 1; i < nums.length && cnt <= 1; i++) {
            if (nums[i - 1] > nums[i]) {
                cnt++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];  //modify nums[i-1] of a priority
                } else {
                    nums[i] = nums[i - 1];     //have to modify nums[i]
                }
            }
        }
        return cnt <= 1;
    }

    public static void main(String[] args) {
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{4, 2, 3}));
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{2, 4, 3}));
        System.out.println(new NonDecreasingArray().checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
