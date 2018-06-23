package dfs;

import java.util.*;

public class WordLadder {
	public List<String> getBackupWords(HashSet<String> dict, HashSet<String> visited, String curWord) {
		List<String> next = new ArrayList<String>();

		for(int i=0; i < curWord.length(); i ++ ){
            StringBuffer sb = new StringBuffer(curWord);
            for(char ch = 'a'; ch <= 'z'; ch += 1) {
				if(curWord.charAt(i) == ch) {
					continue;
				}
				sb.setCharAt(i, ch);
				if(dict.contains(sb.toString()) && !visited.contains(sb.toString())) {
				    visited.add(sb.toString());
				    next.add(sb.toString());
                }
			}
		}
		return next;
	}

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		HashSet<String> dict = new HashSet<String>();
		HashSet<String> visited = new HashSet<String>();
		for(String word : wordList) {
			dict.add(word);
		}
		List<String> nextLevel = new ArrayList<String>();
		List<String> curLevel = null;
		nextLevel.add(beginWord);

		int depth = 0;
		while(nextLevel.size() != 0) {
            curLevel = new ArrayList<String>(nextLevel);
            nextLevel.clear();
            for(String word : curLevel) {
                if(word.equals(endWord)) {
                    return depth + 1; // add beginWord
                }
                nextLevel.addAll(getBackupWords(dict, visited, word));
            }
            depth += 1;
		}
		return 0;
	}
}
