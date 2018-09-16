package array;

class NumArray {

    int[] nums;

    public NumArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
        }
        this.nums = nums;
    }

    public int sumRange(int i, int j) {
        if (i == 0) {
            return this.nums[j];
        }
        return this.nums[j] - this.nums[i - 1];
    }

    public static void main(String[] args) {
        NumArray na = new NumArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(na.sumRange(0, 4));
    }
}
