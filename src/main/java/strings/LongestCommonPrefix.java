package strings;

/**
 *  简单题，拆成两个函数比较容易思考。
 */
public class LongestCommonPrefix {

    public static boolean isAllEaqual(String[] strs, int pos) {
        if (strs.length == 1) {
            return true;
        }
        for (int i = 0; i < strs.length; i++) {
            if (pos >= strs[i].length()) {
                return false;
            }
            if (strs[i].charAt(pos) != strs[0].charAt(pos)) {
                return false;
            }
        }
        return true;
    }

    public static String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if (strs.length == 0) {
            return prefix;
        }
        if (strs.length == 1) {
            return strs[0];
        }
        for (int i = 0; ; i++) {
            if (isAllEaqual(strs, i)) {
                prefix += strs[0].charAt(i);
            } else {
                return prefix;
            }
        }
    }

    public static void main(String[] args) {
//        System.out.println(longestCommonPrefix(new String[]{"abcdefg", "abcde", "abc"}));
        System.out.println(longestCommonPrefix(new String[]{""}));
    }
}
