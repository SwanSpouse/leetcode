package array;

public class NumberOf1Bits {

    public static int hammingWeight(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result += n & 1;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(11));
        System.out.println(hammingWeight(128));
    }
}
