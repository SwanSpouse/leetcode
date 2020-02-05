package tree;

import java.util.ArrayList;

public class MaximumLevelSumOfABinaryTree {
    public int maxLevelSum(TreeNode root) {
        if (root == null) {
            return 1;
        }
        ArrayList<TreeNode> cur = new ArrayList<>();
        ArrayList<TreeNode> next = new ArrayList<>();
        int maxValue = root.val;
        int maxLevel = 1, curLevel = 1;

        next.add(root);
        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
            next.clear();
            int curVal = 0;
            curLevel += 1;
            for (TreeNode node : cur) {
                if (node.left != null) {
                    next.add(node.left);
                    curVal += node.left.val;
                }
                if (node.right != null) {
                    next.add(node.right);
                    curVal += node.right.val;
                }
            }
            if (curVal > maxValue) {
                maxValue = curVal;
                maxLevel = curLevel;
            }
        }
        return maxLevel;
    }
}
