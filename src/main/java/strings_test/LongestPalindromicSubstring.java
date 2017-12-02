package strings_test;

public class LongestPalindromicSubstring {
    // Transform S into T.
    // For example, S = "abba", T = "^#a#b#b#a#$".
    // ^ and $ signs are sentinels appended to each end to avoid bounds checking
    public static String preProcess(String s) {
        int n = s.length();
        if (n == 0) return "^$";

        String ret = "^";
        for (int i = 0; i < n; i++) {
            ret += "#" + s.substring(i, i + 1);
        }

        ret += "#$";
        return ret;
    }

    public static String longestPalindrome(String s) {
        String T = preProcess(s);
        int N = T.length();
        int[] P = new int[N];
        int C = 0, R = 0;

        for (int i = 1; i < N - 1; i++) {
            int mirror = 2 * C - i;
            /*
             R > i
                说明在对称区间内，可以复用左边对称区间的值；
                P[i] = R -i
                    是最大对称区间的半径。
                P[i] = P[mirror]
                    是对称节点的值

             R <= i
                说明没有在对称区间内，只能重新进行计算；
             */
            P[i] = R > i ? Math.min(R - i, P[mirror]) : 0;

            while (T.charAt(i + 1 + P[i]) == T.charAt(i - 1 - P[i])) {
                P[i]++;
            }

            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < N - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }
        // 这里除以2是从T坐标变换回S坐标用的
        return s.substring((centerIndex - 1 - maxLen) / 2, (centerIndex - 1 - maxLen) / 2 + maxLen);
    }
}
