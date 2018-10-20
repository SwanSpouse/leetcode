package detail;

public class SuperUglyNumber {
//    public int nthSuperUglyNumber(int n, int[] primes) {
//        if (n == 0) {
//            return 1;
//        }
//        HashSet<Integer> visited = new HashSet<>();
//        List<Integer> ret = new ArrayList<>();
//        ret.add(1);
//        visited.add(1);
//
//        int[] candidates = Arrays.copyOf(primes, primes.length);
//
//        while (ret.size() < n) {
//            int min = Integer.MAX_VALUE;
//            for (int i = 0; i < candidates.length; i++) {
//                int cur = candidates[i];
//                for (int j = 0; j < primes.length && visited.contains(cur); j++) {
//                    cur = candidates[i] * primes[j];
//                }
//                min = Integer.min(min, cur);
//            }
//            visited.add(min);
//            ret.add(min);
//            Print.PrintArr(candidates);
//            Print.PrintList(ret);
//        }
//        return ret.get(n - 1);
//    }

    // 和UglyNumberII一样。
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] ugly = new int[n];
        int[] idx = new int[primes.length];

        ugly[0] = 1;
        for (int i = 1; i < n; i++) {
            //find next
            ugly[i] = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
                ugly[i] = Math.min(ugly[i], primes[j] * ugly[idx[j]]);

            //slip duplicate
            for (int j = 0; j < primes.length; j++) {
                while (primes[j] * ugly[idx[j]] <= ugly[i]) idx[j]++;
            }
        }
        return ugly[n - 1];
    }

    public static void main(String[] args) {
//        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(15, new int[]{3, 5, 7, 11, 19, 23, 29, 41, 43, 47}));
    }
}
