package array;

import java.util.HashMap;

public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        HashMap<Long, Integer> map = new HashMap<Long, Integer>();

        boolean isNegative = (numerator < 0 || denominator < 0) && !(numerator < 0 && denominator < 0);
        long numeratorll = numerator;
        long denominatorll = denominator;
        numeratorll = Math.abs(numeratorll);
        denominatorll = Math.abs(denominatorll);

        // 处理整除和小数点前的结果
        String ret;
        if (numeratorll >= denominatorll) {
            ret = numeratorll / denominatorll + "";
            numeratorll = numeratorll % denominatorll;
            if (numeratorll != 0) {
                ret += ".";
            }
        } else {
            ret = "0.";
        }
        // 处理小数点后的结果
        int pos = 0;
        int repeatPos = -1;
        while (numeratorll != 0) {
            numeratorll = numeratorll * 10;
            pos += 1;
            if (map.containsKey(numeratorll)) {
                repeatPos = map.get(numeratorll);
                break;
            } else {
                map.put(numeratorll, pos);
            }

            while (numeratorll < denominatorll) {
                numeratorll = numeratorll * 10;
                pos += 1;
                // 找到重复的被除数就结束了；
                if (map.containsKey(numeratorll)) {
                    repeatPos = map.get(numeratorll);
                    break;
                } else {
                    map.put(numeratorll, pos);
                }
                ret += "0";
            }

            if (repeatPos != -1) {
                break;
            }
            ret += numeratorll / denominatorll;
            numeratorll = numeratorll % denominatorll;
        }

        if (repeatPos != -1) {
            String[] fields = ret.split("\\.");
            ret = fields[0] + "." + fields[1].substring(0, repeatPos - 1) + "(" + fields[1].substring(repeatPos - 1) + ")";

        }
        return !isNegative ? ret : "-" + ret;
    }

    public static void main(String[] args) {
//        System.out.println(fractionToDecimal(1, 6));
//        System.out.println(fractionToDecimal(2, 1));
//        System.out.println(fractionToDecimal(2, 4));
//        System.out.println(fractionToDecimal(100, 13));
//        System.out.println(fractionToDecimal(Integer.MIN_VALUE, 1));
        System.out.println(fractionToDecimal(0, 1));
    }
}
