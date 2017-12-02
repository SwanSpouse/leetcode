package strings;

public class ZigZagConversion {

    public static String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int divider = 2 * numRows - 2;
        String ret = "";

        for (int row = 0; row < numRows; row++) {
            int mod1 = row;
            int mod2 = divider - row;

            for (int i = 0; i * divider + mod1 < s.length(); i++) {
                ret = ret + s.charAt(i * divider + mod1);

                if (mod1 != mod2 % divider && i * divider + mod2 < s.length()) {
                    ret = ret + s.charAt(i * divider + mod2);
                }
            }
        }
        return ret;
    }
}
