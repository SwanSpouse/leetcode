package tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABST {

    public void inorderTravel(List<Integer> order, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravel(order, root.left);
        order.add(root.val);
        inorderTravel(order, root.right);
    }

    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> order = new ArrayList<Integer>();
        inorderTravel(order, root);
        return order.get(k - 1);
    }
}
