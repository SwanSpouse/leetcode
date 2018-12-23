package detail;

import utils.Print;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] == 0) {
                    nums[j] = nums[j + 1];
                    nums[j + 1] = 0;
                }
            }
        }
    }

//    public void moveZeros2(int[] nums) {
//        for (int i = 0, j = 0; i < nums.size(); ++i) {
//            if (nums[i]) {
//                swap(nums[i], nums[j++]);
//            }
//        }
//    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
//        int[] nums = new int[]{0, 0, 1};
        new MoveZeroes().moveZeroes(nums);
        Print.printArr(nums);
    }
}
