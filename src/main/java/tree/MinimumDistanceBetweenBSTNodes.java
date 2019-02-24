package tree;

import java.util.ArrayList;

public class MinimumDistanceBetweenBSTNodes {

    public void inorderTravel(ArrayList<Integer> ret, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravel(ret, root.left);
        ret.add(root.val);
        inorderTravel(ret, root.right);
    }

    public int minDiffInBST(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList<>();
        inorderTravel(ret, root);

        int min = Integer.MAX_VALUE;
        for (int i = 1; i < ret.size(); i++) {
            min = Math.min(min, ret.get(i) - ret.get(i - 1));
        }
        return min;
    }
}
