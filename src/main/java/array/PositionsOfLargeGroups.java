package array;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PositionsOfLargeGroups {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> ret = new ArrayList<>();
        if (S.length() == 0) {
            return ret;
        }
        HashMap<Character, Integer> startIndex = new HashMap<>();
        HashMap<Character, Integer> endIndex = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            if (i == 0) {
                startIndex.put(S.charAt(i), i);
            } else if (S.charAt(i) != S.charAt(i - 1)) {
                endIndex.put(S.charAt(i - 1), i - 1);
                startIndex.put(S.charAt(i), i);
                if (endIndex.get(S.charAt(i - 1)) - startIndex.get(S.charAt(i - 1)) + 1 >= 3) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(startIndex.get(S.charAt(i - 1)));
                    list.add(endIndex.get(S.charAt(i - 1)));
                    ret.add(list);
                }
            } else if (i == S.length() - 1) {
                if (S.charAt(i) == S.charAt(i - 1) && i - startIndex.get(S.charAt(i - 1)) + 1 >= 3) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(startIndex.get(S.charAt(i - 1)));
                    list.add(i);
                    ret.add(list);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.print2DIntegerList(new PositionsOfLargeGroups().largeGroupPositions("abbxxxxzyy"));
        Print.print2DIntegerList(new PositionsOfLargeGroups().largeGroupPositions("abcdddeeeeaabbbcd"));
    }
}
