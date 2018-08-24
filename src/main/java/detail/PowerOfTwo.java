package detail;

public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        for (int i = 1; i <= n && i > 0; i = i << 1) {
            if (i == n) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(1024));
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
        System.out.println(new PowerOfTwo().isPowerOfTwo(15));
        System.out.println(new PowerOfTwo().isPowerOfTwo(16));
        System.out.println(new PowerOfTwo().isPowerOfTwo(1073741825));
    }
}
