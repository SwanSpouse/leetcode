package tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfLeftLeaves {

    public void dfs(List<TreeNode> leftLeaves, TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && isLeft) {
            leftLeaves.add(root);
            return;
        }
        dfs(leftLeaves, root.left, true);
        dfs(leftLeaves, root.right, false);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        List<TreeNode> leftLeaves = new ArrayList<TreeNode>();
        dfs(leftLeaves, root, false);
        int sum = 0;
        for (TreeNode node : leftLeaves) {
            sum += node.val;
        }
        return sum;
    }
}
