package tree;

public class UnivaluedBinaryTree {

    public boolean isUnivalTree(TreeNode node, int value) {
        if (node == null) {
            return true;
        }
        if (node.val != value) {
            return false;
        }
        return isUnivalTree(node.left, value) && isUnivalTree(node.right, value);
    }

    public boolean isUnivalTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isUnivalTree(root.left, root.val) && isUnivalTree(root.right, root.val);
    }
}
