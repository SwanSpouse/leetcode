package strings;

public class StringToInteger {

    public static int myAtoi(String str) {
        if (str.trim().length() == 0) {
            return 0;
        }
        str = str.trim();

        boolean positive = true;
        boolean hasSign = false;
        long ret = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '-') {
                if (hasSign) {
                    return 0;
                }
                positive = false;
                hasSign = true;
            } else if (ch == '+') {
                if (hasSign) {
                    return 0;
                }
                positive = true;
                hasSign = true;
            } else if (ch >= '0' && ch <= '9') {
                ret = ret * 10 + ch - '0';
                if (positive && ret > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (!positive && -ret < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                break;
            }

        }
        ret = positive ? ret : -ret;
        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (-ret < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) ret;
    }
}
