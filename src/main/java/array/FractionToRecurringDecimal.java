package array;

import java.util.HashMap;

public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        // 处理整除和小数点前的结果
        String ret;
        if (numerator >= denominator) {
            ret = numerator / denominator + "";
            numerator = numerator % denominator;
            if (numerator != 0) {
                ret += ".";
            }
        } else {
            ret = "0.";
        }
        // 处理小数点后的结果
        int pos = 0;
        int repeatPos = -1;
        while (numerator != 0) {
            numerator = numerator * 10;
            pos += 1;
            if (map.containsKey(numerator)) {
                repeatPos = map.get(numerator);
                break;
            } else {
                map.put(numerator, pos);
            }

            while (numerator < denominator) {
                numerator = numerator * 10;
                pos += 1;
                // 找到重复的被除数就结束了；
                if (map.containsKey(numerator)) {
                    repeatPos = map.get(numerator);
                    break;
                } else {
                    map.put(numerator, pos);
                }
                ret += "0";
            }

            if (repeatPos != -1) {
                break;
            }
            ret += numerator / denominator;
            numerator = numerator % denominator;
        }

        if (repeatPos != -1) {
            String[] fields = ret.split("\\.");
            return fields[0] + "." + fields[1].substring(0, repeatPos - 1) + "(" + fields[1].substring(repeatPos - 1) + ")";
        } else {
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(1, 6));
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 4));
        System.out.println(fractionToDecimal(100, 13));
    }
}
