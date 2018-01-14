package dynamic_programing;

import java.util.*;

/**
 * 暂时还没有想到这道题的考点。就给它归为dp问题吧。
 * 初步想法：
 *      把所有能够用words组成的字符串存成一个Set<String>，然后来依次从s中取子串。（dfs问题）超时了。
 *      问题出在dfs上面。应该有更好的办法来解决这个问题。
 *
 * 查看了网上的答案：
 *      感觉没有什么特别的技巧。就是充分利用了每个单词长度相等的这一条件。把这道题想复杂了。
 */
class SubstringWithConcatenationOfAllWords {

    //    public static void dfs(HashSet<String> ret, String cur, String[] words, HashSet<Integer> isIn) {
//        if (cur.length() / words[0].length() == words.length) {
//            ret.add(cur);
//            return;
//        }
//        for (int i = 0; i < words.length; i++) {
//            if (isIn.contains(i)) {
//                continue;
//            }
//            isIn.add(i);
//            dfs(ret, cur + words[i], words, isIn);
//            isIn.remove(i);
//        }
//    }
//
//    public static HashSet<String> generateAllString(String[] words) {
//        HashSet<String> ret = new HashSet<String>();
//        HashSet<Integer> isIn = new HashSet<Integer>();
//        dfs(ret, "", words, isIn);
//        return ret;
//    }

    public static boolean compareMap(HashMap<String, Integer> origin, HashMap<String, Integer> compare) {
        if (origin.size() != compare.size()) {
            return false;
        }
        for (String key : origin.keySet()) {
            if (origin.get(key) != compare.get(key)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(String input, int wordLength, HashMap<String, Integer> wordMap) {
        HashMap<String, Integer> curMap = new HashMap<String, Integer>();
        for (int i = 0; i < input.length(); i += wordLength) {
            String cur = input.substring(i, i + wordLength);
            if (!wordMap.containsKey(cur)) {
                return false;
            }
            if (curMap.containsKey(cur)) {
                curMap.put(cur, curMap.get(cur) + 1);
            } else {
                curMap.put(cur, 1);
            }
        }
        return compareMap(curMap, wordMap);
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<Integer>();
        if (s.length() == 0 || words.length == 0) {
            return ret;
        }
        if (s.length() < words.length * words[0].length()) {
            return ret;
        }
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        for (String word : words) {
            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }
        int wordLength = words[0].length();
        int targetSubstringLength = wordLength * words.length;
        for (int i = 0; i <= s.length() - targetSubstringLength; i++) {
            if (isValid(s.substring(i, i + targetSubstringLength), wordLength, wordMap)) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
//        HashSet<String> ret  = generateAllString(new String[]{"boo", "far"});
        List<Integer> ret = findSubstring("barfoothefoobarman", new String[]{"foo", "bar"});
        for (Integer item : ret) {
            System.out.println(item);
        }
    }
}