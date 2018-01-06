package strings;

/**
 *      这道题的标准答案是KMP算法。
 */
public class ImplementStrStr {

    public static boolean compare(String str, String subStr) {
        if (str.length() < subStr.length()) {
            return false;
        }
        for (int i = 0; i < str.length() && i < subStr.length(); i++) {
            if (str.charAt(i) != subStr.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.equals(needle)) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            if (compare(haystack.substring(i, haystack.length()), needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("hello", "ll"));
        System.out.println(strStr("aaaaa", "bba"));
        System.out.println(strStr("", ""));
        System.out.println(strStr("mississippi", "pi"));
    }
}
