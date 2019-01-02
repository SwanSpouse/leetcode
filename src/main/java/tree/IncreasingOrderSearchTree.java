package tree;

public class IncreasingOrderSearchTree {

    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode newRoot = root;
        if (root.left != null) {
            newRoot = increasingBST(root.left);
            TreeNode cur = newRoot;
            while (cur.right != null) {
                cur = cur.right;
            }
            cur.right = root;
            root.left = null;
        }
        if (root.right != null) {
            root.right = increasingBST(root.right);
        }
        return newRoot;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.constructTree(new char[]{'7', '5', '9', '4', '6', '8'});
        Tree.levelOrderTravel(new IncreasingOrderSearchTree().increasingBST(root));
    }
}
