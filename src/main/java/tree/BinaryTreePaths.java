package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

    public void dfs(List<String> ret, TreeNode node, String cur) {
        if (node.left == null && node.right == null) {
            ret.add(cur);
            return;
        }
        if (node.left != null) {
            dfs(ret, node.left, cur + "->" + node.left.val);
        }
        if (node.right != null) {
            dfs(ret, node.right, cur + "->" + node.right.val);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ret = new ArrayList<String>();
        if (root == null) {
            return ret;
        }
        dfs(ret, root, root.val + "");
        return ret;
    }
}
