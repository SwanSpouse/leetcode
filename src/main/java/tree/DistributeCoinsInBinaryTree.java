package tree;

public class DistributeCoinsInBinaryTree {

    private int totalMoves = 0;

    public int weight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + weight(root.left) + weight(root.right);
    }

    public void balance(TreeNode father, TreeNode node) {
        if (node == null) {
            return;
        }
        int leftWeight = weight(node.left);
        int rightWeight = weight(node.right);

        if (leftWeight >= rightWeight) {
            balance(node, node.left);
            balance(node, node.right);
        } else {
            balance(node, node.right);
            balance(node, node.left);
        }
        if (node.val > 1) {
            if (father != null) {
                father.val += node.val - 1;
            }
            totalMoves += node.val - 1;
        } else if (node.val < 1) {
            if (father != null) {
                father.val -= 1 - node.val;
            }
            totalMoves += 1 - node.val;
        }
        node.val = 1;
    }

    public int distributeCoins(TreeNode root) {
        balance(null, root);
        return totalMoves;
    }
}
