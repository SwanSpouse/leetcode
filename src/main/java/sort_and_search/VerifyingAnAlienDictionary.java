package sort_and_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        String[] copy = Arrays.copyOf(words, words.length);

        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        Arrays.sort(copy, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                for (int i = 0; i < o1.length() && i < o2.length(); i++) {
                    if (orderMap.get(o1.charAt(i)) < orderMap.get(o2.charAt(i))) {
                        return -1;
                    } else if (orderMap.get(o1.charAt(i)) > orderMap.get(o2.charAt(i))) {
                        return 1;
                    }
                }
                if (o1.length() < o2.length()) {
                    return -1;
                } else if (o1.length() > o2.length()) {
                    return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < copy.length; i++) {
            if (!words[i].equals(copy[i])) {
                return false;
            }
        }
        return true;
    }
}
