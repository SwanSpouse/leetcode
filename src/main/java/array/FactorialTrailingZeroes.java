package array;


/**
 * n!后缀0的个数 = n!质因子中5的个数 = floor(n/5) + floor(n/25) + floor(n/125) + ....
 */
public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        return n / 5 == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        System.out.println(trailingZeroes(10));
        System.out.println(trailingZeroes(1808548329));
    }
}
