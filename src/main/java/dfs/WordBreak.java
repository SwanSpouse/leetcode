package dfs;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
    public boolean dfs(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word) && dfs(s.substring(word.length()), wordDict)) {
                return true;
            }
        }
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // 做一个简单的剪枝操作
        HashSet<Character> chars = new HashSet<Character>();
        for (String word : wordDict) {
            for(Character c : word.toCharArray()) {
                chars.add(c);
            }
        }
        for(Character c : s.toCharArray()) {
            if(!chars.contains(c)) {
                return false;
            }
        }
        Collections.sort(wordDict);
        Collections.reverse(wordDict);
        return dfs(s, wordDict);
    }
}
