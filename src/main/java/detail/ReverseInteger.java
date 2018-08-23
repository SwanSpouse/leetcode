package detail;

public class ReverseInteger {
    public static int reverse(int x) {
        long ret = 0;
        while (x != 0) {
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        return ret > Integer.MAX_VALUE || ret < Integer.MIN_VALUE ? 0 : (int) ret;
    }
}
