package strings;

public class ReverseStringII {

    public String reverseStr(String s, int k) {
        StringBuffer ret = new StringBuffer();
        boolean isReverse = true;
        for (int i = 0; i < s.length(); i += k) {
            if (isReverse) {
                int j = i + k >= s.length() ? s.length() : i + k;
                for (j = j - 1; j >= i; j--) {
                    ret.append(s.charAt(j));
                }
                isReverse = false;
            } else {
                for (int j = i; j < i + k && j < s.length(); j++) {
                    ret.append(s.charAt(j));
                }
                isReverse = true;
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseStringII().reverseStr("abcdefg", 2));
    }
}
