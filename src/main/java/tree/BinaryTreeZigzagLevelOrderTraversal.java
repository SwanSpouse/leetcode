package tree;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();
        next.add(root);
        boolean isReverse = false;
        while (!next.isEmpty()) {
            cur = new ArrayList<TreeNode>(next);
            next.clear();
            List<Integer> vals = new ArrayList<Integer>();
            for (TreeNode item : cur) {
                if (item == null) {
                    continue;
                }
                vals.add(item.val);
                next.add(item.left);
                next.add(item.right);
            }
            if (!vals.isEmpty()) {
                if (isReverse) {
                    Collections.reverse(vals);
                }
                ret.add(new ArrayList<Integer>(vals));
                isReverse = !isReverse;
            }
        }
        return ret;
    }
}
