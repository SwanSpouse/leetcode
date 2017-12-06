package strings;

public class RegularExpressionMatching {

    public static String simplyExpression(String p) {
        if (p.length() == 0) {
            return p;
        }
        boolean isEndWithStar = p.charAt(p.length() - 1) == '*';
        String[] fields = p.split("\\*");
        String ret = fields[0];

        for (int i = 0; i < fields.length - 1; i++) {
            if (fields[i].endsWith(fields[i + 1])) {
                if (i + 1 == fields.length - 1 && !isEndWithStar) {
                    ret += "*" + fields[i+1];
                }
                continue;
            }
            ret += "*" + fields[i + 1];
        }
        if (isEndWithStar && !ret.endsWith("*")) {
            ret = ret + "*";
        }
        return ret;
    }

    public static boolean isMatchSimple(String s, String p) {
        if (p.equals(s)) {
            return true;
        }
        if (p.length() == 0) {
            return s.length() == 0;
        }
        if (p.length() == 1) {
            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
        }
        if (p.charAt(1) == '*') {
            // 相等或者不相等 1. 把a*过滤掉
            // 相等             2. 吞掉p的一个a
            // 相等             3. 过滤a*, 同时吞掉一个a
            if (s.length() == 0) {
                return isMatchSimple(s, p.substring(2, p.length()));
            }
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return isMatchSimple(s, p.substring(2, p.length())) || isMatchSimple(s.substring(1, s.length()), p) || isMatchSimple(s.substring(1, s.length()), p.substring(2, p.length()));
            } else {
                return isMatchSimple(s, p.substring(2, p.length()));
            }
        } else {
            if (s.length() == 0) {
                return false;
            }
            if (p.charAt(0) == '.' || p.charAt(0) == s.charAt(0)) {
                return isMatchSimple(s.substring(1, s.length()), p.substring(1, p.length()));
            } else {
                return false;
            }
        }
    }

    /**
     * s: a*b*c*
     * p: aab
     */
    public static boolean isMatch(String s, String p) {
        String ps = simplyExpression(p);
//        System.out.println(p + " ==> " + ps);
        return isMatchSimple(s, ps);
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("aa", "a*"));
        System.out.println(isMatch("cacbcacbacbccac", ".*c*c*bb*c*..*a*a"));
    }
}
