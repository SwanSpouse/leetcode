package detail;

import java.util.ArrayList;
import java.util.Collections;

public class KClosestPointsToOrigin {

    private static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            return this.x * this.x + this.y * this.y - o.x * o.x - o.y * o.y;
        }
    }

    public int[][] kClosest(int[][] points, int K) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < points.length; i++) {
            list.add(new Pair(points[i][0], points[i][1]));
        }
        Collections.sort(list);

        int[][] ret = new int[K][2];
        for (int i = 0; i < K; i++) {
            ret[i][0] = list.get(i).x;
            ret[i][1] = list.get(i).y;
        }
        return ret;
    }
}
