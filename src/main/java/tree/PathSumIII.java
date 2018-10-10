package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumIII {

    public void dfs(List<Integer> ret, TreeNode root, int sum) {
        if (sum == root.val) {
            ret.add(1);
        }
        if (root.left != null) {
            dfs(ret, root.left, sum - root.val);
        }
        if (root.right != null) {
            dfs(ret, root.right, sum - root.val);
        }
    }

    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int ret = 0;
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        next.add(root);
        while (!next.isEmpty()) {
            cur = new ArrayList<TreeNode>(next);
            next.clear();
            for (TreeNode node : cur) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                dfs(temp, node, sum);
                ret += temp.size();
                if (node.left != null) {
                    next.add(node.left);
                }
                if (node.right != null) {
                    next.add(node.right);
                }
            }
        }
        return ret;
    }
}
