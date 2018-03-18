package dynamic_programing;

public class DecodeWays {

//    public static boolean checkValid(String s) {
//        for (int i = 1; i < s.length(); i++) {
//            if (s.charAt(i) == '0' && (Integer.parseInt("" + s.charAt(i - 1) + s.charAt(i)) > 26 || Integer.parseInt("" + s.charAt(i - 1) + s.charAt(i)) <= 0)) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public static int dfs(String s) {
//        if (s.equals("0")) {
//            return 0;
//        }
//        if (s.length() <= 1) {
//            return 1;
//        }
//        if (s.charAt(0) == '0') {
//            return dfs(s.substring(1, s.length()));
//        }
//        if (s.charAt(1) == '0') {
//            return dfs(s.substring(2, s.length()));
//        }
//        String sub = s.substring(0, 2);
//        if (Integer.parseInt(sub) <= 26) {
//            return dfs(s.substring(1, s.length())) + dfs(s.substring(2, s.length()));
//        }
//        return dfs(s.substring(1, s.length()));
//    }
//
//    public static int numDecodings(String s) {
//        if (s.length() == 0 || s.charAt(0) == '0' || !checkValid(s))
//            return 0;
//        return dfs(s);
//    }

    public static boolean checkValid(char i) {
        return i != '0';
    }

    public static boolean checkValid(char i, char j) {
        return i != '0' && Integer.parseInt("" + i + j) <= 26 && Integer.parseInt("" + i + j) > 0;
    }

    // 动态规划
    public static int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (!checkValid(s.charAt(i)) && !checkValid(s.charAt(i - 1), s.charAt(i))) {
                return 0;
            }
            if (checkValid(s.charAt(i))) {
                dp[i] = dp[i - 1];
            }
            if (checkValid(s.charAt(i - 1), s.charAt(i))) {
                dp[i] = i - 2 >= 0 ? dp[i] + dp[i - 2] : dp[i] + 1;
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("123"));
        System.out.println(numDecodings("37"));
        System.out.println(numDecodings("103"));
        System.out.println(numDecodings("10"));
        System.out.println(numDecodings("9371597631128776948387197132267188677349946742344217846154932859125134924241649584251978418763151253"));
    }
}
