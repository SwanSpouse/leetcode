package strings;

public class RemoveOutermostParentheses {
    public String removeOuterParentheses(String S) {
        StringBuffer sb = new StringBuffer();

        int left = 0, right = 0;
        int start = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '(') {
                left += 1;
            } else {
                right += 1;
            }
            if (left != 0 && left == right) {
                sb.append(S.substring(start + 1, i));
                start = i + 1;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())"));
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(new RemoveOutermostParentheses().removeOuterParentheses("()()"));
    }
}
