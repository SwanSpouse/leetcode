package detail;

import utils.Print;

import java.util.ArrayList;

public class DecompressRunLengthEncodedList {
    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; 2 * i + 1 < nums.length; i++) {
            int a = nums[i * 2], b = nums[i * 2 + 1];
            for (int j = 0; j < a; j++) {
                ret.add(b);
            }
        }
        return ret.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Print.printArr(new DecompressRunLengthEncodedList().decompressRLElist(new int[]{1, 2, 3, 4}));
    }
}
