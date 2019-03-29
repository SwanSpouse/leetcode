package strings;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] A) {
        List<String> ret = new ArrayList<>();
        if (A.length == 0) {
            return ret;
        }
        List<int[]> count = new ArrayList<>();

        for (int i = 0; i < A.length; i++) {
            int[] cur = new int[26];
            for (int j = 0; j < A[i].length(); j++) {
                cur[A[i].charAt(j) - 'a'] += 1;
            }
            count.add(cur);
        }

        for (int i = 0; i < 26; i++) {
            int minContainTimes = count.get(0)[i];
            for (int j = 1; j < count.size(); j++) {
                minContainTimes = Math.min(minContainTimes, count.get(j)[i]);
            }
            for (int j = 0; j < minContainTimes; j++) {
                ret.add((char) ('a' + i) + "");
            }
        }
        return ret;
    }
}
