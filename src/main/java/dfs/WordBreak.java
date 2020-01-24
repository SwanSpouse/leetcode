package dfs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<String>(wordDict);

        boolean[] dp = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (i != 0 && dp[i - 1] == false) {
                continue;
            }
            for (String word : set) {
                if (i + word.length() <= s.length() && word.contains(s.substring(i, i + word.length()))) {
                    dp[i + word.length() - 1] = true;
                }
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        String[] words = new String[]{"cats", "dog", "sand", "and", "cat"};
        System.out.println(wordBreak("catsandog", Arrays.asList(words)));
    }
}
