package detail;

import java.util.ArrayList;

public class PerfectNumber {

    public ArrayList<Integer> getDevidors(int num) {
        ArrayList<Integer> ret = new ArrayList<>();
        if (num == 1) {
            return ret;
        }
        for (int i = 1; i < num; i++) {
            if (num % i == 0) {
                ret.add(i);
            }
        }
        return ret;
    }

    public boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) {
            return false;
        }
        ArrayList<Integer> dividors = getDevidors(num);
        int sum = 0;
        for (int i = 0; i < dividors.size(); i++) {
            sum += dividors.get(i);
        }
        return sum == num;
    }
}
