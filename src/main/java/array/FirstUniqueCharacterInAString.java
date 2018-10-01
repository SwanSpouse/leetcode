package array;

public class FirstUniqueCharacterInAString {
    public int firstUniqChar(String s) {
        int[] letter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            letter[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (letter[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
