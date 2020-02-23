package sort_and_search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class SortCharactersByFrequency {
    class Pair {
        Character first;
        Integer second;

        Pair(Character c, Integer i) {
            this.first = c;
            this.second = i;
        }
    }

    public String repeat(Character a, int count) {
        StringBuffer ret = new StringBuffer();
        for (int i = 0; i < count; i++) {
            ret.append(a);
        }
        return ret.toString();
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!count.containsKey(s.charAt(i))) {
                count.put(s.charAt(i), 1);
            } else {
                count.put(s.charAt(i), count.get(s.charAt(i)) + 1);
            }
        }

        ArrayList<Pair> list = new ArrayList<>();
        for (Character key : count.keySet()) {
            list.add(new Pair(key, count.get(key)));
        }
        list.sort(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.second - o1.second;
            }
        });

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            sb.append(repeat(list.get(i).first, list.get(i).second));
        }
        return sb.toString();
    }
}
