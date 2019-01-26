package tree;

public class BinaryTreeTilt {

    public int sumSubTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumSubTree(root.left) + sumSubTree(root.right) + root.val;
    }

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = sumSubTree(root.left);
        int right = sumSubTree(root.right);

        return Math.abs(left - right) + findTilt(root.left) + findTilt(root.right);
    }
}
