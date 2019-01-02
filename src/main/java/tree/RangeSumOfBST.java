package tree;

public class RangeSumOfBST {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }
        int sum = L <= root.val && root.val <= R ? root.val : 0;
        if (root.val >= L) {
            sum += rangeSumBST(root.left, L, R);
        }
        if (root.val <= R) {
            sum += rangeSumBST(root.right, L, R);
        }
        return sum;
    }
}
