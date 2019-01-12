package bit_manipulation;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int ret = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ret = ret ^ nums[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(new int[]{1, 1, 2, 3, 3}));
    }
}
