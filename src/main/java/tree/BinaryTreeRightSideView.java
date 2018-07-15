package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null) {
            return ret;
        }
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        ArrayList<TreeNode> cur;
        next.add(root);

        while (!next.isEmpty()) {
            ret.add(next.get(next.size() - 1).val);
            cur = new ArrayList<TreeNode>(next);
            next.clear();
            for (TreeNode node : cur) {
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
