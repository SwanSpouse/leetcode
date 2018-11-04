package bit_manipulation;

public class IsPowerOfFour {
    boolean isPowerOfFour(int n) {
        return (n & (n - 1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new IsPowerOfFour().isPowerOfFour((int) Math.pow(4, i)));
        }
    }
}
