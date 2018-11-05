package bit_manipulation;

public class ReverseBits {
    int reverseBits(int n) {
        int mask = 1 << 31, res = 0;
        for (int i = 0; i < 32; ++i) {
            if ((n & 1) > 0) {
                res |= mask;
            }
            mask >>= 1;
            n >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseBits().reverseBits(10));
    }
}
