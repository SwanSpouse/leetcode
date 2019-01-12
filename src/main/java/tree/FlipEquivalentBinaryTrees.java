package tree;

public class FlipEquivalentBinaryTrees {

    public boolean isSame(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return root1.val == root2.val && isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
    }

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isSame(root1, root2)) {
            return true;
        }
        return root1.val == root2.val && ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) ||
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)));
    }
}
