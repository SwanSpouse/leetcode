package detail;

public class SubtractTheProductAndSumOfDigitsOfAnInteger {
    public int subtractProductAndSum(int n) {
        int sum = 0, product = 1;
        while (n != 0) {
            int cur = n % 10;
            sum += cur;
            product *= cur;
            n = n / 10;
        }
        return product - sum;
    }

    public static void main(String[] args) {
        System.out.println((new SubtractTheProductAndSumOfDigitsOfAnInteger()).subtractProductAndSum(234));
    }
}
