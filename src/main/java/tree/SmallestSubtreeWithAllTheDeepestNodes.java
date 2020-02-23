package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class SmallestSubtreeWithAllTheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        ArrayList<TreeNode> next = new ArrayList<>();
        ArrayList<TreeNode> cur = new ArrayList<>();
        HashMap<TreeNode, TreeNode> fatherMap = new HashMap<>();
        next.add(root);

        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
            next.clear();
            for (TreeNode node : cur) {
                if (node.left != null) {
                    next.add(node.left);
                    fatherMap.put(node.left, node);
                }
                if (node.right != null) {
                    next.add(node.right);
                    fatherMap.put(node.right, node);
                }
            }
        }
        if (cur.size() == 1) {
            return cur.get(0);
        }
        HashSet<TreeNode> fatherSet = new HashSet<>();
        HashSet<TreeNode> nextFatherSet = new HashSet<>();
        for (TreeNode node : cur) {
            fatherSet.add(fatherMap.get(node));
        }

        while (fatherSet.size() != 1) {
            Iterator<TreeNode> it = fatherSet.iterator();
            while (it.hasNext()) {
                TreeNode node = it.next();
                it.remove();
                nextFatherSet.add(fatherMap.get(node));
            }
            fatherSet = new HashSet<>(nextFatherSet);
            nextFatherSet.clear();
        }
        for (TreeNode ret : fatherSet) {
            return ret;
        }
        return null;
    }
}
