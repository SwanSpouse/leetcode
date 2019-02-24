package tree;

import java.util.ArrayList;

public class MinimumAbsoluteDifferenceInBST {

    public void inorderTravel(TreeNode root, ArrayList<Integer> ret) {
        if (root == null) {
            return;
        }
        inorderTravel(root.left, ret);
        ret.add(root.val);
        inorderTravel(root.right, ret);
    }

    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ArrayList<Integer> order = new ArrayList<>();
        inorderTravel(root, order);

        int minDifference = Integer.MAX_VALUE;
        for (int i = 0; i < order.size() - 1; i++) {
            minDifference = Math.min(minDifference, order.get(i + 1) - order.get(i));
        }
        return minDifference;
    }
}
