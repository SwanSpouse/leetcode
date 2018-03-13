package strings;

public class WildcardMatching {

    public static String simplyPattern(String p) {
        String ret = "";
        for (int i = 0; i < p.length(); i++) {
            if (ret.length() > 0 && ret.charAt(ret.length() - 1) == '*' && p.charAt(i) == '*') {
                continue;
            }
            ret = ret + p.charAt(i);
        }
        return ret;
    }

    public static boolean isMatchSimply(String s, String p) {
        if (s.equals(p) || (p.length() > 0 && p.replace("*", "").equals(""))) {
            return true;
        }
        if (s.length() == 0) {
            return false;
        }
        if (s.length() != 0 && p.length() == 0) {
            return false;
        }
        if (p.charAt(0) == '*') {
            return isMatchSimply(s.substring(1, s.length()), p.substring(1, p.length())) || isMatchSimply(s.substring(1, s.length()), p) || isMatchSimply(s, p.substring(1, p.length()));
        }
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?') {
            return isMatchSimply(s.substring(1, s.length()), p.substring(1, p.length()));
        }
        return false;
    }

    public static boolean isMatch(String s, String p) {
        return isMatchSimply(s, simplyPattern(p));
    }

    public static void main(String[] args) {
//        System.out.println(isMatch("a", "aa"));
//        System.out.println(isMatch("aa", "aa"));
//        System.out.println(isMatch("aaa", "aa"));
//        System.out.println(isMatch("aa", "*"));
//        System.out.println(isMatch("aa", "a*"));
//        System.out.println(isMatch("ab", "?*"));
//        System.out.println(isMatch("aab", "c*a*b"));
//        System.out.println(isMatch("c", "*?*"));
//        System.out.println(isMatch("ho", "ho**"));
//        System.out.println(isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b"));
        System.out.println(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"));
    }
}

// timeout input
//"bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab"
//"b*b*ab**ba*b**b***bba"