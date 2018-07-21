package array;

public class BitwiseANDOfNumbersRange {

    public int rangeBitwiseAnd(int m, int n) {
        if (m == 0) {
            return 0;
        }
        int lowerBound = 1;
        int upperBound = 2;

        if (m >= Integer.MAX_VALUE >> 1) {
            lowerBound = m;
            upperBound = n;
        } else {
            while (!(lowerBound <= m && m < upperBound)) {
                lowerBound = lowerBound << 1;
                upperBound = upperBound << 1;
            }
        }
        lowerBound = Math.max(m, lowerBound);
        upperBound = Math.min(n, upperBound);

        System.out.println("m:" + m + " n:" + n + " lower:" + lowerBound + " upper:" + upperBound);

        int ret = lowerBound;
        for (int i = lowerBound + 1; i <= upperBound && i >= 0 ; i++) {
            ret = ret & i;
        }
        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(0, 1));
//        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(5, 7));
//        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(1, 10));
        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(2147483646, 2147483647));
//        System.out.println(new BitwiseANDOfNumbersRange().rangeBitwiseAnd(1, Integer.MAX_VALUE));
    }
}

