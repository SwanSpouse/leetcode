package array;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {


    public List<Integer> findDuplicates(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                res.add(Math.abs(nums[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 2, 8, 7, 2, 3, 1};
        Print.printList(new FindAllDuplicatesInAnArray().findDuplicates(input));
    }
}
