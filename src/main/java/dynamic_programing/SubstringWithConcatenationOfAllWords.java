package dynamic_programing;

import java.util.*;

/**
 * 暂时还没有想到这道题的考点。就给它归为dp问题吧。
 * 初步想法：
 *      把所有能够用words组成的字符串存成一个Set<String>，然后来依次从s中取子串。（dfs问题）超时了。
 *      问题出在dfs上面。应该有更好的办法来解决这个问题。
 */
class SubstringWithConcatenationOfAllWords {

    public static void dfs(HashSet<String> ret, String cur, String[] words, HashSet<Integer> isIn) {
        if (cur.length() / words[0].length() == words.length) {
            ret.add(cur);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (isIn.contains(i)) {
                continue;
            }
            isIn.add(i);
            dfs(ret, cur + words[i], words, isIn);
            isIn.remove(i);
        }
    }

    public static HashSet<String> generateAllString(String[] words) {
        HashSet<String> ret = new HashSet<String>();
        HashSet<Integer> isIn = new HashSet<Integer>();
        dfs(ret, "", words, isIn);
        return ret;
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        if (s.length() == 0 || words.length == 0) {
            return ret;
        }
        if (s.length() < words.length * words[0].length()) {
            return ret;
        }
        int targetSentenceLength = words.length * words[0].length();
        HashSet<String> sentences = generateAllString(words);
        for (int i = 0; i <= s.length() - targetSentenceLength; i++) {
            String cur = s.substring(i, i + targetSentenceLength);
            if (sentences.contains(cur)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        HashSet<String> ret  = generateAllString(new String[]{"boo", "far"});
        List<Integer> ret = findSubstring("barfoothefoobarman", new String[]{"boo", "far"});
        for (Integer item : ret) {
            System.out.println(item);
        }
    }
}