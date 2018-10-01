package strings;

import java.util.HashSet;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s.length() == 0) {
            return s;
        }
        HashSet<Character> vowel = new HashSet<Character>();
        vowel.add('a');vowel.add('A');
        vowel.add('e');vowel.add('E');
        vowel.add('i');vowel.add('I');
        vowel.add('o');vowel.add('O');
        vowel.add('u');vowel.add('U');

        StringBuffer sb = new StringBuffer(s);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !vowel.contains(sb.charAt(left))) {
                left += 1;
            }
            while (left < right && !vowel.contains(sb.charAt(right))) {
                right -= 1;
            }

            Character temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left += 1;
            right -= 1;
        }
        return sb.toString();
    }
}
