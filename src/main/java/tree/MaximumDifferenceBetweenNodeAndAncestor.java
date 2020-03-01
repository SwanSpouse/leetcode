package tree;

public class MaximumDifferenceBetweenNodeAndAncestor {

    private int maxVal = 0;

    public void path(TreeNode cur, int origin) {
        if (cur == null) {
            return;
        }
        maxVal = Math.max(maxVal, Math.abs(cur.val - origin));
        path(cur.left, origin);
        path(cur.right, origin);
    }

    public void dfs(TreeNode cur) {
        if (cur == null) {
            return;
        }
        path(cur.left, cur.val);
        path(cur.right, cur.val);

        dfs(cur.left);
        dfs(cur.right);
    }

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return maxVal;
    }
}
