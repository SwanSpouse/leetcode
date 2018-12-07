package array;

import utils.Print;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return people;

        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (b[0] == a[0]) return a[1] - b[1];
                return b[0] - a[0];
            }
        });

        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            // 它前面都是比它大的，所以直接按照它的count来放就完了。
            list.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }

        for (int i = 0; i < list.size(); i++) {
            people[i][0] = list.get(i)[0];
            people[i][1] = list.get(i)[1];
        }
        return people;
    }

    public static void main(String[] args) {
        Print.Print2DArr(new QueueReconstructionByHeight().reconstructQueue(new int[][]{
                {7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2},
        }));
    }
}
