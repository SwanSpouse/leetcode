package strings;

public class ReverseWordsInAStringIII {

    /**
     简单题，操作字符串
     */
    public String reverse(String s) {
        StringBuilder ret = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--) {
            ret.append(s.charAt(i));
        }
        return ret.toString();
    }

    public String reverseWords(String s) {
        StringBuilder ret = new StringBuilder("");

        String[] fields = s.split(" ");
        for (String val : fields) {
            ret.append(reverse(val) + " ");
        }
        ret.deleteCharAt(ret.length() - 1);
        return ret.toString();
    }
}
