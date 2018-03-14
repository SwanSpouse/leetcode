package strings;

public class WildcardMatching {

    public static boolean isMatch(String s, String p) {
        boolean hasStar = false;
        int i = 0, j = 0;
        for (; i < s.length() && j < p.length(); i++, j++) {
            if (p.charAt(j) == '?') {
                continue;
            } else if (p.charAt(j) == '*') {
                hasStar = true;
                while (j < p.length() && p.charAt(j) == '*') {
                    j++;
                }
                if (j == p.length()) {
                    return true;
                }
                i = i - 1;
                j = j - 1;
            } else {
                if (s.charAt(i) != p.charAt(j)) {
                    if (!hasStar) {
                        return false;
                    }
                    j = j - 1;
                }
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j += 1;
        }
        return j == p.length() && i == s.length();
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
//        System.out.println(isMatch("babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab", "***bba**a*bbba**aab**b")); //false
//        System.out.println(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"));//false
        System.out.println(isMatch("zacabz", "*a?b*"));
    }
}

// timeout input
//"bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab"
//"b*b*ab**ba*b**b***bba"