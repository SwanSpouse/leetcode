package bit_manipulation;

public class KeepAsMany1BitsAsPossible {
    // Find the largest power of 2 (most significant bit in binary form), which is less than or equal to the given number N.

    public int largestPower(int N) {
        //changing all right side bits to 1.
        N = N | (N >> 1);
        N = N | (N >> 2);
        N = N | (N >> 4);
        N = N | (N >> 8);
        N = N | (N >> 16);
        return (N + 1) >> 1;
    }

    public static void main(String[] args) {
        for(int i =0; i < 100; i ++ ) {
            System.out.println(new KeepAsMany1BitsAsPossible().largestPower(i));
        }
    }
}
