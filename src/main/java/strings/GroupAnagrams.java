package strings;

import java.util.*;

/**
 * 想法是构建一个排序好String->List这样的HashMap。这个方法居然AC了。查一查。不然这道题太让我失望了。
 */
class GroupAnagrams {

	public static String sortString(String input) {
		char[] arr = input.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();

        for(String str : strs) {
			String sortedStr = sortString(str);
			if(map.containsKey(sortedStr)) {
				map.get(sortedStr).add(str);
			} else {
				ArrayList<String> cur = new ArrayList<String>();
				cur.add(str);
				map.put(sortedStr, cur);
			}
        }
        for(String key : map.keySet()){
        	ret.add(map.get(key));
        }

        return ret;
    }
}