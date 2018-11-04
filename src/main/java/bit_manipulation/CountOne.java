package bit_manipulation;

public class CountOne {
    // Count the number of ones in the binary representation of the given number
    int countOne(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count += 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountOne().countOne(7));
        System.out.println(new CountOne().countOne(3));
        System.out.println(new CountOne().countOne(4));
        System.out.println(new CountOne().countOne(8));
    }
}
