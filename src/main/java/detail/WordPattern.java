package detail;

import java.util.HashMap;
import java.util.HashSet;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] fields = str.split(" ");
        if (pattern.length() != fields.length) {
            return false;
        }
        HashMap<Character, String> map = new HashMap<Character, String>();
        HashSet<String> set = new HashSet<String>();

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                String temp = map.get(pattern.charAt(i));
                if (!temp.equals(fields[i])) {
                    return false;
                }
            } else {
                if (set.contains(fields[i])) {
                    return false;
                }
                map.put(pattern.charAt(i), fields[i]);
                set.add(fields[i]);
            }
        }
        return true;
    }
}
