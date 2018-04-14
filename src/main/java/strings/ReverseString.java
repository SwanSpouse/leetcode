package strings;

public class ReverseString {
    /**
    简单题，StringBuffer和StringBuilder的区别在于, StringBuffer是线程安全的。
     */
    public String reverseString(String s) {
        StringBuilder ret = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }
}
