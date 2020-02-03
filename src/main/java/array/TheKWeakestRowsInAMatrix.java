package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TheKWeakestRowsInAMatrix {

    class Row {
        int num;
        int soldiers;

        Row(int num, int soldiers) {
            this.num = num;
            this.soldiers = soldiers;
        }
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        ArrayList<Row> rows = new ArrayList<>();

        for (int i = 0; i < mat.length; i++) {
            int count = 0;
            for (int j = 0; j < mat[i].length; j++) {
                count += mat[i][j] == 1 ? 1 : 0;
            }
            rows.add(new Row(i, count));
        }

        Collections.sort(rows, new Comparator<Row>() {
            @Override
            public int compare(Row o1, Row o2) {
                if (o1.soldiers == o2.soldiers) {
                    return o1.num - o2.num;
                }
                return o1.soldiers - o2.soldiers;
            }
        });

        int[] ret = new int[k];
        for (int i = 0; i < k; i++) {
            ret[i] = rows.get(i).num;
        }
        return ret;
    }
}
