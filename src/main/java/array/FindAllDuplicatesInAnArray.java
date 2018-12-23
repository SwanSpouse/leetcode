package array;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray {

    public void findAPlace(int[] nums, int pos) {
        int cur = nums[pos];
        while (cur != pos + 1 && cur != nums[cur - 1]) {
            int temp = nums[cur - 1];
            nums[cur - 1] = cur;
            cur = temp;
        }
        nums[pos] = cur;
    }

    public List<Integer> findDuplicates(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i + 1) {
                continue;
            }
            findAPlace(nums, i);
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                ret.add(nums[i]);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        int[] input = new int[]{4, 3, 2, 8, 7, 2, 3, 1};
        Print.printList(new FindAllDuplicatesInAnArray().findDuplicates(input));
    }
}
