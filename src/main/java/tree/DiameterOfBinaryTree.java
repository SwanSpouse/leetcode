package tree;

public class DiameterOfBinaryTree {

    public int max(int x, int y, int z) {
        return Math.max(x, Math.max(y,z));
    }

    public int countDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(countDepth(root.left), countDepth(root.right)) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int cur = countDepth(root.left) + countDepth(root.right);
        int left = diameterOfBinaryTree(root.left);
        int right = diameterOfBinaryTree(root.right);

        return max(cur, left, right);
    }
}
