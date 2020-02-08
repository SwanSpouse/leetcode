package detail;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public boolean containsZero(int n) {
        return (n + "").contains("0");
    }

    public int[] getNoZeroIntegers(int n) {
        int[] ret = new int[2];
        for (int i = 1; i <= n / 2; i++) {
            if (!containsZero(i) && !containsZero(n - i)) {
                ret[0] = i;
                ret[1] = n - i;
                return ret;
            }
        }
        return ret;
    }
}
