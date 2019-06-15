package sort_and_search;

import java.util.*;

public class CustomSortString {
    public String customSortString(String S, String T) {
        List<Character> input = new ArrayList<>();
        for (Character c : T.toCharArray()) {
            input.add(c);
        }
        HashMap<Character, Integer> sortMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            sortMap.put(S.charAt(i), i);
        }

        Collections.sort(input, new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                int weight1 = sortMap.containsKey(o1) ? sortMap.get(o1) : Integer.MAX_VALUE;
                int weight2 = sortMap.containsKey(o2) ? sortMap.get(o2) : Integer.MAX_VALUE;
                return weight1 - weight2;
            }
        });
        StringBuffer sb = new StringBuffer();
        for (Character c : input) {
            sb.append(c);
        }
        return sb.toString();
    }
}
