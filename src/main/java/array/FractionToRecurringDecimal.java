package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
            numerator = numerator * 10;
        }
        // 处理小数点后的结果
        int opCount = 0;
        boolean hasFindRepeatRange = false;
        while (numerator != 0) {
            numerator = numerator * 10;
            opCount += 1;

            if (map.containsKey(numerator)) {
                hasFindRepeatRange = true;
                break;
            } else {
                map.put(numerator, opCount);
            }

            while (numerator < denominator) {
                numerator = numerator * 10;
                opCount += 1;
                // 找到重复的被除数就结束了；
                if (map.containsKey(numerator)) {
                    hasFindRepeatRange = true;
                    break;
                } else {
                    map.put(numerator, opCount);
                }
                ret += "0";
            }

            if (hasFindRepeatRange) {
                break;
            }
            ret += numerator / denominator;
            numerator = numerator % denominator;
        }

        if (hasFindRepeatRange) {
            ArrayList<Integer> pos = new ArrayList<Integer>();
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                pos.add(e.getValue());
            }
            Collections.sort(pos);

            String[] fields = ret.split("\\.");
            return fields[0] + "." + fields[1].substring(0, pos.get(0) - 1) + "(" + fields[1].substring(pos.get(0) - 1, pos.get(pos.size() - 1) - 1) + ")";
        } else {
            return ret;
        }
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(2, 1));
        System.out.println(fractionToDecimal(2, 4));
        System.out.println(fractionToDecimal(100, 13));
    }
}
