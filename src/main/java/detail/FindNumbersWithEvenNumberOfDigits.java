package detail;

public class FindNumbersWithEvenNumberOfDigits {

    public int findNumbers(int[] nums) {
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            ret += (new String(nums[i] + "")).length() % 2 == 0 ? 1 : 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new FindNumbersWithEvenNumberOfDigits().findNumbers(new int[]{555, 901, 482, 1771}));
        System.out.println(new FindNumbersWithEvenNumberOfDigits().findNumbers(new int[]{12,345,2,6,7896}));
    }
}
