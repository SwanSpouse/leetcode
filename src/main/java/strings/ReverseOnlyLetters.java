package strings;

public class ReverseOnlyLetters {

    public boolean isLetter(Character c) {
        return ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z');
    }

    public String reverseOnlyLetters(String S) {
        StringBuffer sb = new StringBuffer(S);
        int left = 0, right = S.length()-1;
        while(left < right) {
            while(left < right && !isLetter(S.charAt(left))) {
                left += 1;
            }
            while(left < right && !isLetter(S.charAt(right))) {
                right -= 1;
            }
            Character c = S.charAt(left);
            sb.setCharAt(left, S.charAt(right));
            sb.setCharAt(right, c);
            left += 1;
            right -= 1;
        }
        return sb.toString();
    }
}
