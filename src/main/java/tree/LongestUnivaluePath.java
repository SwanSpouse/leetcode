package tree;

public class LongestUnivaluePath {

    public int maxPath = 0;

    public int curPathLength(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = 0, right = 0;
        if(root.left != null && root.left.val == root.val) {
            left = curPathLength(root.left);
        }
        if(root.right != null && root.right.val == root.val) {
            right = curPathLength(root.right);
        }
        return 1 + Math.max(left, right);
    }

    public void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.left);

        int cur = 1;
        if(root.left != null && root.left.val == root.val) {
            cur += curPathLength(root.left);
        }
        if(root.right != null && root.right.val == root.val) {
            cur += curPathLength(root.right);
        }
        this.maxPath = Math.max(this.maxPath, cur);

        dfs(root.right);
    }

    public int longestUnivaluePath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        dfs(root);
        return maxPath;
    }
}
