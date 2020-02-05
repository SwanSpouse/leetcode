package tree;

import utils.Print;

import java.util.*;

// https://leetcode.com/problems/path-in-zigzag-labelled-binary-tree/discuss/497583/Java-O(log-n-)-solution-using-the-path-and-symmetric-path
// 看看人家怎么做的
public class PathInZigzagLabelledBinaryTree {
//    public List<Integer> pathInZigZagTree(int label) {
//        LinkedList<Integer> ret = new LinkedList<>();
//        if (label == 0) {
//            return ret;
//        }
//        HashMap<Integer, Integer> fathers = new HashMap<>();
//
//        ArrayList<Integer> cur = new ArrayList<>();
//        ArrayList<Integer> next = new ArrayList<>();
//        next.add(1);
//
//        int left = 1, right = 1, leavesCount = 1;
//        boolean fromLeft = false;
//        while (left < label) {
//            cur = new ArrayList<>(next);
//            next.clear();
//
//            leavesCount *= 2;
//            left = right + 1;
//            right = left + leavesCount - 1;
//
//            if (fromLeft) {
//                for (int i = left, index = 0; i <= right; i++, index++) {
//                    fathers.put(i, cur.get(index / 2));
//                    next.add(i);
//                }
//            } else {
//                for (int i = right, index = 0; i >= left; i--, index++) {
//                    fathers.put(i, cur.get(index / 2));
//                    next.add(i);
//                }
//            }
//            fromLeft = !fromLeft;
//        }
//
//
//        int trace = label;
//        while (trace != 1) {
//            ret.addFirst(trace);
//            trace = fathers.get(trace);
//        }
//        ret.addFirst(1);
//        return ret;
//    }

    public List<Integer> pathInZigZagTree(int label) {
        Stack<Integer> path = new Stack<>();
        int tmp = label;
        while (tmp > 1) {
            path.push(tmp % 2);
            tmp /= 2;
        }
        int[][] values = new int[2][path.size() + 1];
        values[0][0] = 1;
        values[1][0] = 1;
        int step = 1;
        while (!path.isEmpty()) {
            int dir = path.pop();
            values[0][step] = values[0][step - 1] * 2 + (dir == 0 ? 1 : 0);
            values[1][step] = values[1][step - 1] * 2 + dir;
            ++step;
        }

        List<Integer> res = new ArrayList<>();
        int index = step % 2;
        for (int i = 0; i < step; ++i) {
            res.add(values[(index + i) % 2][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Print.printList(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(14));
        Print.printList(new PathInZigzagLabelledBinaryTree().pathInZigZagTree(26));
    }
}
