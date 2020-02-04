package tree;

import java.util.ArrayList;
import java.util.HashSet;

class FindElements {

    HashSet<Integer> set = new HashSet<>();

    public FindElements(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> next = new ArrayList<>();
        ArrayList<TreeNode> cur;

        root.val = 0;
        next.add(root);

        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
            next.clear();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    node.left.val = node.val * 2 + 1;
                    set.add(node.left.val);
                    next.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 2;
                    set.add(node.right.val);
                    next.add(node.right);
                }
            }
        }
    }

    public boolean find(int target) {
        return set.contains(target);
    }
}
