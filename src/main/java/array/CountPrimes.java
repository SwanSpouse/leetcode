package array;

//https://www.cnblogs.com/grandyang/p/4462810.html

public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 0;
        int ret = 0;
        for (int i = 2; i < n; i++) {
            if (arr[i] == 0) {
                ret += 1;
            } else {
                continue;
            }
            for (int j = 2; i * j < n; j++) {
                arr[i * j] = 1;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(100));
    }
}
