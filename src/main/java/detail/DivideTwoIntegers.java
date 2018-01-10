package detail;

class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
        if( divisor == 0 ) {
            return Integer.MAX_VALUE;
        }
        boolean isNegative = false;
        if (dividend < 0 && divisor < 0) {
            dividend = -dividend;
            divisor = -divisor;
        }else if (dividend < 0 || divisor < 0) {
            isNegative = true;
            dividend = dividend < 0 ? -dividend : dividend;
            divisor = divisor < 0 ? -divisor : divisor;
        }
        int count =0;
        int left = dividend;
        while(left >= divisor) {
            left = left - divisor;
            count += 1;
        }
        count = isNegative ? -count : count;
        return count;
    }

    public static void main(String[] args) {
        System.out.Println(divide(10, 3));
    }
}

