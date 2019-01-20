package tree;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;

public class MostFrequentSubtreeSum {

    public void incr(HashMap<Integer, Integer> pathSum, int path) {
        if (pathSum.containsKey(path)) {
            pathSum.put(path, pathSum.get(path) + 1);
        } else {
            pathSum.put(path, 1);
        }
    }

    public int sumTree(TreeNode root, HashMap<Integer, Integer> pathSum) {
        if (root == null) {
            return 0;
        }
        int cur = root.val + sumTree(root.left, pathSum) + sumTree(root.right, pathSum);
        incr(pathSum, cur);
        return cur;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        HashMap<Integer, Integer> pathSum = new HashMap<>();
        sumTree(root, pathSum);

        int max = Integer.MIN_VALUE;
        for (int key : pathSum.keySet()) {
            max = Math.max(max, pathSum.get(key));
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (int key : pathSum.keySet()) {
            if (max == pathSum.get(key)) {
                ret.add(key);
            }
        }
        int[] ans = new int[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            ans[i] = ret.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        Print.printArr(new MostFrequentSubtreeSum().findFrequentTreeSum(Tree.constructTree(new int[]{5, 2, -3})));
        Print.printArr(new MostFrequentSubtreeSum().findFrequentTreeSum(Tree.constructTree(new int[]{5, 2, -5})));
    }
}
