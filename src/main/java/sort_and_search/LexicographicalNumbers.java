package sort_and_search;

import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {

    public void generate(List<Integer> ret, int index, int n) {
        int cur = ret.get(index) * 10;
        for (int i = 0; i <= 9; i++) {
            if (cur + i > n) {
                break;
            }
            ret.add(cur + i);
            generate(ret, index + 1, n);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (n == 0) {
            return ret;
        }
        int index = 0;
        for (int i = 1; ret.size() < n; i++) {
            ret.add(i);
            for (; index < ret.size() && ret.size() < n; index++) {
                generate(ret, index, n);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        new LexicographicalNumbers().lexicalOrder(13);
    }
}
