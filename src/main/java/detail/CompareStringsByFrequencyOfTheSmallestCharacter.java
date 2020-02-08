package detail;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public int count(String input) {
        int[] cur = new int[26];
        for (int i = 0; i < input.length(); i++) {
            cur[input.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if (cur[i] != 0) {
                return cur[i];
            }
        }
        return 0;
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] ret = new int[queries.length];
        int[] counts = new int[words.length];

        for (int i = 0; i < words.length; i++) {
            counts[i] = count(words[i]);
        }

        for (int i = 0; i < queries.length; i++) {
            int cur = 0;
            for (int j = 0; j < words.length; j++) {
                if (count(queries[i]) < counts[j]) {
                    cur += 1;
                }
            }
            ret[i] = cur;
        }
        return ret;
    }
}
