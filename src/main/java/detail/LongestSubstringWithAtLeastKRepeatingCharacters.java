package detail;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

    public boolean isValid(int[] input, int k) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] != 0 && input[i] < k) {
                return false;
            }
        }
        return true;
    }

    public int longestSubstring(String s, int k) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] count = new int[26];
            for (int j = i; j < s.length(); j++) {
                count[s.charAt(j) - 'a'] += 1;
                if (isValid(count, k)) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("aaabb", 3));
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("ababbc", 2));
    }
}
