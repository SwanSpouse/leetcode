package strings;

import java.util.HashMap;

public class IntegerToRoman {

    public static String appendChar(String input, int nums, String ch) {
        for (int i = 0; i < nums; i++) {
            input += ch;
        }
        return input;
    }

    public static String intToRoman(int num) {
        String roman = "";
        if (num == 0) {
            return roman;
        }
        HashMap<Integer, String[]> map = new HashMap<Integer, String[]>();
        map.put(1000, new String[]{"M"});
        map.put(100, new String[]{"C", "CD", "D", "CM"});
        map.put(10, new String[]{"X", "XL", "L", "XC"});
        map.put(1, new String[]{"I", "IV", "V", "IX"});

        for (int divider = 1000; divider > 0; divider /= 10) {
            int quotient = num / divider;
            num = num % divider;
            String[] cur = map.get(divider);
            if (quotient == 0) {
                continue;
            }
            if (quotient == 1) {
                roman += cur[0];
            }
            if (quotient == 4) {
                roman += cur[1];
            }
            if (quotient == 5) {
                roman += cur[2];
            }
            if (quotient == 9) {
                roman += cur[3];
            }
            if (1 < quotient && quotient < 4) {
                roman = appendChar(roman, quotient, cur[0]);
            }
            if (5 < quotient && quotient < 9) {
                roman += cur[2];
                roman = appendChar(roman, quotient - 5, cur[0]);
            }
        }
        return roman;
    }
}
