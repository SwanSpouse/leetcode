package detail;

/**
 * 这种细节题坑还是很多的。
 * 这种题如果超时的话就应该想到用位运算来解决。
 * <p>
 * 思路：
 * 两个数字相除：如果不允许使用除法。那么最先应该想到的是减法 ==> 然后减法的过程可以进行优化。
 * e.g. 28 =  3*2ˆ3 +3*2ˆ0 +1 所以, 3* (2ˆ3 + 2ˆ0) + 1 = 28，结果就是(2^3 + 2^0) = 9
 * <p>
 * 最后再考虑一些特殊情况。就是越界啊, 什么的。
 * 这里面有一种特殊情况。就是如果 dividend = Integer.MAX_VALUE -1 那么可能在左移的过程中，永远不会小于dividend。这个需要特殊的处理。
 * 如果是dividend = Integer.MIN_VALUE, 那么其中一些操作可能会越界。这里需要通过扩大精度来处理。
 * <p>
 * 感觉这道题主要考察的点是在精度上。
 */


class DivideTwoIntegers {
    // First edition : timeout 这个方法也需要先提高精度。然后再进行运算。
    // public static int divide(int dividend, int divisor) {
    //     if( divisor == 0 ) {
    //         return Integer.MAX_VALUE;
    //     }
    //     if (dividend == Integer.MIN_VALUE && divisor == -1 ) {
    //         return Integer.MAX_VALUE;
    //     }
    //     boolean isNegative = false;
    //     if (dividend < 0 && divisor < 0) {
    //         dividend = -dividend;
    //         divisor = -divisor;
    //     }else if (dividend < 0 || divisor < 0) {
    //         isNegative = true;
    //         dividend = dividend < 0 ? -dividend : dividend;
    //         divisor = divisor < 0 ? -divisor : divisor;
    //     }
    //     int count =0;
    //     int left = dividend;
    //     while(left >= divisor) {
    //         left = left - divisor;
    //         count += 1;
    //     }
    //     count = isNegative ? -count : count;
    //     return count;
    // }

    public static int divide(int dividend, int divisor) {
        long dividendL = dividend;
        long divisorL = divisor;
        if (divisorL == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividendL == Integer.MIN_VALUE && divisorL == -1) {
            return Integer.MAX_VALUE;
        }
        dividendL = Math.abs(dividendL);
        divisorL = Math.abs(divisorL);
        int ret = 0;
        while (divisorL <= dividendL) {
            int shiftLeftCount = 0;
            long cur = divisorL;
            while ((cur << 1) <= dividendL && cur <= (Integer.MAX_VALUE >> 1)) {
                cur = (cur << 1);
                shiftLeftCount += 1;
            }
            dividendL = dividendL - cur;
            ret = ret + (1 << shiftLeftCount);
        }
        ret = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0) ? -ret : ret;
        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(divide(10, 3));
//        System.out.println(divide(28, 9));
//        System.out.println(divide(100, 1));
//        System.out.println(divide(Integer.MAX_VALUE, 1));
        System.out.println(divide(Integer.MIN_VALUE, -2));
    }
}