package sort_and_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ret.add(i);
        }
        Collections.sort(ret, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (o1 + "").compareTo(o2 + "");
            }
        });
        return ret;
    }

    public static void main(String[] args) {
        new LexicographicalNumbers().lexicalOrder(13);
    }
}
