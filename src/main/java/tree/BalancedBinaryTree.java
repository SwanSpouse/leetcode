package tree;

import java.util.HashMap;

/**
 * 这里引入了map是为了防止重复计算。
 */
public class BalancedBinaryTree {
    HashMap<TreeNode, Integer> heightMap = new HashMap<TreeNode, Integer>();

    public int getHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    public int getAndSetHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (heightMap.containsKey(node)) {
            return heightMap.get(node);
        }
        return getHeight(node);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(getAndSetHeight(root.left) - getAndSetHeight(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
}
