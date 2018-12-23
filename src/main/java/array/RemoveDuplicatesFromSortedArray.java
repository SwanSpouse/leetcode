package array;

import utils.Print;

public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = 0;
        int fast = slow + 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow += 1;
                nums[slow] = nums[fast];
            }
            fast += 1;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[]{1, 1, 1, 2, 2};
        System.out.println(removeDuplicates(input));
        Print.printArr(input);
    }
}
