package strings;

import java.util.HashMap;

public class RomanToInteger {
    public static int romanToInt(String s) {
        if (s.equals("")) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int lastInt = 0;
        int ret = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = map.get(s.charAt(i));
            if (cur >= lastInt) {
                ret += cur;
                lastInt = cur;
            } else {
                ret -= cur;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("CMXC"));
    }
}
