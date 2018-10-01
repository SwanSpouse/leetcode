package strings;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] letter = new int[26];
        for (int i = 0; i < t.length(); i++) {
            letter[t.charAt(i) - 'a'] += 1;

        }
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] -= 1;
        }
        for (int i = 0; i < letter.length; i++) {
            if (letter[i] != 0) {
                return (char) ('a' + i);
            }
        }
        return ' ';
    }
}
