package detail;

import java.util.*;

public class SelfDividingNumbers {

    public boolean isSelfDividingNumber(int input) {
        int origin = input;
        while (input != 0) {
            int tail = input % 10;
            if (tail == 0 || origin % tail != 0) {
                return false;
            }
            input = input / 10;
        }
        return true;
    }

    public List<Integer> selfDividingNumbers(int left, int right) {
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            if (isSelfDividingNumber(i)) {
                ret.add(i);
            }
        }
        return ret;
    }
}