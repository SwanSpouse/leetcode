package tree;

import java.util.ArrayList;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        ArrayList<TreeNode> next = new ArrayList<>();
        ArrayList<TreeNode> cur = new ArrayList<>();
        next.add(root);

        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
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
        return cur.get(0).val;
    }
}
