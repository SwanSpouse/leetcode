package tree;

public class BinaryTreePruning {

    public boolean notContains1(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (notContains1(root.left)) {
            root.left = null;
        }
        if (notContains1(root.right)) {
            root.right = null;
        }
        return root.val == 0 && root.left == null && root.right == null;
    }

    public TreeNode pruneTree(TreeNode root) {
        if (notContains1(root)) {
            return null;
        }
        return root;
    }
}
