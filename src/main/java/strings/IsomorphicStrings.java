package strings;

import java.util.HashMap;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Character> s2t = new HashMap<Character, Character>();
        HashMap<Character, Character> t2s = new HashMap<Character, Character>();

        for (int i = 0; i < s.length(); i++) {
            if ((s2t.containsKey(s.charAt(i)) && s2t.get(s.charAt(i)) != t.charAt(i)) ||
                    (t2s.containsKey(t.charAt(i)) && t2s.get(t.charAt(i)) != s.charAt(i))) {
                return false;
            } else {
                s2t.put(s.charAt(i), t.charAt(i));
                t2s.put(t.charAt(i), s.charAt(i));
            }
        }
        return true;
    }
}
