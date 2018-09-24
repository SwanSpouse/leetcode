package array;

public class NumArrayWithUpdate {
    int[] nums;
    int[] array ;
    public NumArrayWithUpdate(int[] nums) {
        this.nums = nums;
        this.array = new int[nums.length];
        for(int i=0; i < nums.length; i ++ ) {
            if ( i == 0) {
                this.array[i] = nums[i];
            } else {
                this.array[i] = this.array[i-1] + nums[i];
            }
        }
    }

    public void update(int i, int val) {
        int diff = val - this.nums[i];
        this.nums[i] = val;
        for(int index = i; index < this.array.length; index += 1) {
            this.array[index] += diff;
        }
    }

    public int sumRange(int i, int j) {
        if(i == 0) {
            return this.array[j];
        }
        return this.array[j] - this.array[i-1];
    }

    public static void main(String[] args) {
        NumArrayWithUpdate nau = new NumArrayWithUpdate(new int[] {1,3,5});
        System.out.println(nau.sumRange(0, 2));
        nau.update(1,2);
        System.out.println(nau.sumRange(0, 2));
    }
}
