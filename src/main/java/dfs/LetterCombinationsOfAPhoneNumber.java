package dfs;

import java.util.*;

/**
*	这种题都是这种套路，想当年刘总还总结了一个模板。
*/

public class LetterCombinationsOfAPhoneNumber {

	public static void dfs(HashMap<Character,String> map, String digits, String cur, int pos, List<String>ret) {
		if (pos >= digits.length()) {
				ret.add(cur);
				return;
		}
		String backup = map.get(digits.charAt(pos));
		for(int i=0; i < backup.length(); i ++ ) {
			dfs(map, digits, cur + backup.charAt(i), pos + 1, ret);
		}
	}

	public static List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if (digits.equals("")){
        	return ret;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(map, digits, "", 0, ret);
        return ret;
    }
}