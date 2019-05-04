package detail;

import java.util.HashMap;

// Set<Integer> primes = new HashSet<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19 /*, 23, 29 */ ));
// 可以把质数都列出来，省去了检测的麻烦。
public class PrimeNumberOfSetBitsInBinaryRepresentation {
    private String intToBinary(int input) {
        StringBuffer sb = new StringBuffer();
        while (input != 0) {
            sb.insert(0, input % 2);
            input = input / 2;
        }
        return sb.toString();
    }

    private boolean isPrime(int input) {
        if (input <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(input); i++) {
            if (input % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int L, int R) {
        HashMap<Integer, Boolean> primes = new HashMap<>();
        int ret = 0;
        for (int i = L; i <= R; i++) {
            String binary = intToBinary(i);
            int count = 0;
            for (int j = 0; j < binary.length(); j++) {
                if (binary.charAt(j) == '1') {
                    count += 1;
                }
            }
            if (!primes.containsKey(count)) {
                primes.put(count, isPrime(count));
            }
            ret += primes.get(count) == true ? 1 : 0;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new PrimeNumberOfSetBitsInBinaryRepresentation().countPrimeSetBits(10, 15));
    }
}
