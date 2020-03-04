package array;

import utils.Print;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class QueensThatCanAttackTheKing {

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> ret = new ArrayList<>();

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < queens.length; i++) {
            set.add(queens[i][0] + "," + queens[i][1]);
        }

        int x = king[0], y = king[1];
        // up
        for (int j = y + 1; j < 8; j++) {
            if (set.contains(x + "," + j)) {
                ArrayList cur = new ArrayList<>();
                cur.add(x);
                cur.add(j);
                ret.add(cur);
                break;
            }
        }
        // down
        for (int j = y - 1; j >= 0; j--) {
            if (set.contains(x + "," + j)) {
                ArrayList cur = new ArrayList<>();
                cur.add(x);
                cur.add(j);
                ret.add(cur);
                break;
            }
        }
        // left
        for (int i = x - 1; i >= 0; i--) {
            if (set.contains(i + "," + y)) {
                ArrayList cur = new ArrayList<>();
                cur.add(i);
                cur.add(y);
                ret.add(cur);
                break;
            }
        }
        // right
        for (int i = x + 1; i < 8; i++) {
            if (set.contains(i + "," + y)) {
                ArrayList cur = new ArrayList<>();
                cur.add(i);
                cur.add(y);
                ret.add(cur);
                break;
            }
        }
        // left up
        for (int i = x - 1, j = y + 1; i >= 0 && j < 8; i--, j++) {
            if (set.contains(i + "," + j)) {
                ArrayList cur = new ArrayList<>();
                cur.add(i);
                cur.add(j);
                ret.add(cur);
                break;
            }
        }
        // left down
        for (int i = x + 1, j = y - 1; i < 8 && j >= 0; i++, j--) {
            if (set.contains(i + "," + j)) {
                ArrayList cur = new ArrayList<>();
                cur.add(i);
                cur.add(j);
                ret.add(cur);
                break;
            }
        }
        // right up
        for (int i = x + 1, j = y + 1; i < 8 && j < 8; i++, j++) {
            if (set.contains(i + "," + j)) {
                ArrayList cur = new ArrayList<>();
                cur.add(i);
                cur.add(j);
                ret.add(cur);
                break;
            }
        }
        // left down
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (set.contains(i + "," + j)) {
                ArrayList cur = new ArrayList<>();
                cur.add(i);
                cur.add(j);
                ret.add(cur);
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.print2DIntegerList(new QueensThatCanAttackTheKing().queensAttacktheKing(new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}}, new int[]{0, 0}));
    }
}
