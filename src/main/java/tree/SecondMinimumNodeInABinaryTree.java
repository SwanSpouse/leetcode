package tree;

public class SecondMinimumNodeInABinaryTree {


    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return -1;
        }
        return 0;
    }
}
