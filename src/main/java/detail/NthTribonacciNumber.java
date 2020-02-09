package detail;

public class NthTribonacciNumber {
    public int tribonacci(int n) {
        int[] arr = new int[Math.max(n + 1, 3)];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        if (n <= 2) {
            return arr[n];
        }
        for (int i = 3; i <= n; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}
