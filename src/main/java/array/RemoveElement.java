package array;

import utils.Print;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int slow = -1;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != val) {
                slow += 1;
                nums[slow] = nums[fast];
            }
            fast += 1;
        }
        return slow + 1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(arr, 3));
        Print.printArr(arr);
    }
}
