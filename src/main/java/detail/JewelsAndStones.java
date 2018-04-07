package detail;

import java.util.*;

public class JewelsAndStones {
    // 打算利用Set
    public int numJewelsInStones(String J, String S) {
        HashSet<Character> dict = new HashSet<Character>();
        for (int i = 0; i < J.length(); i++) {
            dict.add(J.charAt(i));
        }
        int count = 0;
        for (int i = 0; i < S.length(); i++) {
            if (dict.contains(S.charAt(i))) {
                count += 1;
            }
        }
        return count;
    }
}