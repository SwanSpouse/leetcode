package tree;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PathInZigzagLabelledBinaryTree {
    public List<Integer> pathInZigZagTree(int label) {
        LinkedList<Integer> ret = new LinkedList<>();
        if (label == 0) {
            return ret;
        }
        HashMap<Integer, Integer> fathers = new HashMap<>();

        ArrayList<Integer> cur = new ArrayList<>();
        ArrayList<Integer> next = new ArrayList<>();
        next.add(1);

        int left = 1, right = 1, leavesCount = 1;
        boolean fromLeft = false;
        while (left < label) {
            cur = new ArrayList<>(next);
            next.clear();

            leavesCount *= 2;
            left = right + 1;
            right = left + leavesCount - 1;

            if (fromLeft) {
                for (int i = left, index = 0; i <= right; i++, index++) {
                    fathers.put(i, cur.get(index / 2));
                    next.add(i);
                }
            } else {
                for (int i = right, index = 0; i >= left; i--, index++) {
                    fathers.put(i, cur.get(index / 2));
                    next.add(i);
                }
            }
            fromLeft = !fromLeft;
        }


        int trace = label;
        while (trace != 1) {
            ret.addFirst(trace);
            trace = fathers.get(trace);
        }
        ret.addFirst(1);
        return ret;
    }

    public static void main(String[] args) {
        Print.printList(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(14));
        Print.printList(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(26));
    }
}
