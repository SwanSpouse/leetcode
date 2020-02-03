package tree;

public class SumOfNodesWithEvenValuedGrandparent {

    public int ret = 0;

    public void dfs(TreeNode root, boolean isFatherEvenValue) {
        if (root.left != null) {
            if (isFatherEvenValue) {
                ret += root.left.val;
            }
            dfs(root.left, root.val % 2 == 0);
        }

        if (root.right != null) {
            if (isFatherEvenValue) {
                ret += root.right.val;
            }
            dfs(root.right, root.val % 2 == 0);
        }
    }

    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, false);
        return ret;
    }
}
