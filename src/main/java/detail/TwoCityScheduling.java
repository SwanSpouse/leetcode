package detail;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoCityScheduling {

    private class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int twoCitySchedCost(int[][] costs) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            list.add(new Pair(costs[i][0], costs[i][1]));
        }

        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return (o1.x - o1.y) - (o2.x - o2.y);
            }
        });

        int cost = 0;
        for (int i = 0; i < list.size() / 2; i++) {
            cost += list.get(i).x;
            cost += list.get(list.size() / 2 + i).y;
        }
        return cost;
    }

    public static void main(String[] args) {
        System.out.println(new TwoCityScheduling().twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}));
    }
}
