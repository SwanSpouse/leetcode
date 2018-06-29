package tree;

public class PathSum {
    public boolean pathSum(TreeNode node, int cur, int target) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return cur + node.val == target;
        }
        return pathSum(node.left, cur + node.val, target) || pathSum(node.right, cur + node.val, target);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return pathSum(root, 0, sum);
    }
}
