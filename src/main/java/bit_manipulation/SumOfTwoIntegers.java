package bit_manipulation;

public class SumOfTwoIntegers {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        System.out.println(new SumOfTwoIntegers().getSum(1,2));
        System.out.println(new SumOfTwoIntegers().getSum(3,2));
        System.out.println(new SumOfTwoIntegers().getSum(6,2));
        System.out.println(new SumOfTwoIntegers().getSum(8,2));
    }
}
