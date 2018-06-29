package tree;

/**
 * 把左子树拍扁然后接到root和right中间。
 */
public class FlattenBinaryTreeToLinkedList {
    public TreeNode flattenTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode leftLastNode = flattenTree(root.left);
        TreeNode rightLastNdoe = flattenTree(root.right);
        if (leftLastNode != null) {
            leftLastNode.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLastNdoe != null) {
            return rightLastNdoe;
        } else {
            return leftLastNode;
        }
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenTree(root);
    }
}
