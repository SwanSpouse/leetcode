package detail;

import java.util.ArrayList;

public class ReachANumber {

    public int reachNumber(int target) {
        int step = 1;

        ArrayList<Integer> cur;
        ArrayList<Integer> next = new ArrayList<>();
        next.add(0);
        while (true) {
            cur = new ArrayList<>(next);
            next.clear();
            for (int i = 0; i < cur.size(); i++) {
                if (cur.get(i) + step == target || cur.get(i) - step == target) {
                    return step;
                }
                next.add(cur.get(i) + step);
                next.add(cur.get(i) - step);
            }
            step += 1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new ReachANumber().reachNumber(3));
        System.out.println(new ReachANumber().reachNumber(2));
    }
}
