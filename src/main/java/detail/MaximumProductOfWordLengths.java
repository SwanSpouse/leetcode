package detail;

public class MaximumProductOfWordLengths {

    public int product(String word1, String word2) {
        int[] bitmap = new int[26];
        for (Character c : word1.toCharArray()) {
            bitmap[c - 'a'] = 1;
        }
        for (Character c : word2.toCharArray()) {
            if(bitmap[c - 'a'] == 1) {
                return 0;
            }
        }
        return word1.length() * word2.length();
    }

    public int maxProduct(String[] words) {
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                max = Integer.max(max, product(words[i], words[j]));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"a","aa","aaa","aaaa"}));
        System.out.println(new MaximumProductOfWordLengths().maxProduct(new String[]{"a", "ab", "ac"}));
    }
}

