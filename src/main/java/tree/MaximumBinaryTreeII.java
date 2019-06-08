package tree;

import java.util.ArrayList;
import java.util.List;

public class MaximumBinaryTreeII {

    public TreeNode construct(List<Integer> preOrder, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(preOrder.get(left));
        }
        int maxIndex = left;
        int max = preOrder.get(left);
        for (int i = left; i <= right; i++) {
            if (preOrder.get(i) > max) {
                maxIndex = i;
                max = preOrder.get(i);
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(preOrder, left, maxIndex - 1);
        node.right = construct(preOrder, maxIndex + 1, right);
        return node;
    }


    public void preOrderTravel(List<Integer> preOrder, TreeNode root) {
        if (root == null) {
            return;
        }
        preOrderTravel(preOrder, root.left);
        preOrder.add(root.val);
        preOrderTravel(preOrder, root.right);
    }

    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        ArrayList<Integer> preOrder = new ArrayList<>();
        preOrderTravel(preOrder, root);
        preOrder.add(val);
        return construct(preOrder, 0, preOrder.size() - 1);
    }
}
