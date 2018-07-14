package array;

public class FindPeakElement {

    /*
    这道题为啥难度是Medium呢？
     */
    public int findPeakElement(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int left = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
            int right = i == nums.length - 1 ? Integer.MIN_VALUE : nums[i + 1];

            if (nums[i] > left && nums[i] > right) {
                return i;
            }
        }
        return 0;
    }
}
