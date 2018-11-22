package detail;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

//    public boolean isValid(int[] input, int k) {
//        for (int i = 0; i < input.length; i++) {
//            if (input[i] != 0 && input[i] < k) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    public int longestSubstring(String s, int k) {
//        int max = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int[] count = new int[26];
//            for (int j = i; j < s.length(); j++) {
//                count[s.charAt(j) - 'a'] += 1;
//                if (isValid(count, k)) {
//                    max = Math.max(max, j - i + 1);
//                }
//            }
//        }
//        return max;
//    }

    public int longestSubstring(String s, int k) {
        return helper(s.toCharArray(), 0, s.length(), k);
    }

    public int helper(char[] chs, int left, int right, int k) {
        if (right - left < k) return 0;
        int[] count = new int[26];
        for (int i = left; i < right; i++)
            count[chs[i] - 'a']++;
        for (int i = left; i < right; i++) {
            if (count[chs[i] - 'a'] < k) {
                int j = i + 1;
                while (j < right && count[chs[j] - 'a'] < k) j++;
                return Math.max(helper(chs, left, i, k), helper(chs, j, right, k));
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("aaabb", 3));
        System.out.println(new LongestSubstringWithAtLeastKRepeatingCharacters().longestSubstring("ababbc", 2));
    }
}
