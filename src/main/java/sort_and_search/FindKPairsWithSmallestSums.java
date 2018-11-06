package sort_and_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindKPairsWithSmallestSums {

    public static class Position {
        int pos1;
        int pos2;

        public Position(int pos1, int pos2) {
            this.pos1 = pos1;
            this.pos2 = pos2;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<Position> all = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                all.add(new Position(nums1[i], nums2[j]));
            }
        }
        Collections.sort(all, new Comparator<Position>() {
            @Override
            public int compare(Position o1, Position o2) {
                return (o1.pos1 + o1.pos2) - (o2.pos1 + o2.pos2);
            }
        });

        List<int[]> ret = new ArrayList<>();
        int i = 0;
        while (ret.size() < k && i < all.size()) {
            ret.add(new int[]{all.get(i).pos1, all.get(i).pos2});
            i += 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        List<int[]> ret = new FindKPairsWithSmallestSums().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 6);
        for (int[] item : ret) {
            System.out.println(item[0] + " " + item[1]);
        }
        System.out.println();
    }
}
