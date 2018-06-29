package tree;

import java.util.*;

public class PathSumII {

    public void dfs(List<List<Integer>> ret, ArrayList<Integer> cur, TreeNode node, int curSum, int target) {
        if (node == null) {
            return;
        }
        cur.add(node.val);
        if (node.left == null && node.right == null) {
            if (curSum + node.val == target) {
                ret.add(new ArrayList(cur));
            }
            cur.remove(cur.size() - 1);
            return;
        }
        dfs(ret, cur, node.left, curSum + node.val, target);
        dfs(ret, cur, node.right, curSum + node.val, target);
        cur.remove(cur.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        dfs(ret, cur, root, 0, sum);
        return ret;
    }
}
