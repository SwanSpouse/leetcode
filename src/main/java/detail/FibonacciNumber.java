package detail;

public class FibonacciNumber {
    public int fib(int N) {
        if (N == 0 || N == 1) {
            return N;
        }
        int a0 = 0, a1 = 1, ret = 0;
        for (int i = 2; i <= N; i++) {
            ret = a0 + a1;
            a0 = a1;
            a1 = ret;
        }
        return ret;
    }
}
