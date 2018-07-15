package array;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class RepeatedDNASequences {

    public static List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        HashSet<String> ret = new HashSet<String>();

        for (int i = 0; i < s.length() - 9; i++) {
            String substr = s.substring(i, i + 10);
            if (dict.containsKey(substr)) {
                ret.add(substr);
                continue;
            } else {
                dict.put(substr, i);
            }
        }
        return new ArrayList<String>(ret);
    }

    public static void main(String[] args) {
        Print.PrintList(findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}