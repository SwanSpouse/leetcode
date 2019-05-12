package tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeToGreaterSumTree {

    public void postOrderTravel(List<TreeNode> postOrder, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTravel(postOrder, root.right);
        postOrder.add(root);
        postOrderTravel(postOrder, root.left);
    }

    public TreeNode bstToGst(TreeNode root) {
        ArrayList<TreeNode> postOrder = new ArrayList<>();
        postOrderTravel(postOrder, root);

        for (int i = 1; i < postOrder.size(); i++) {
            postOrder.get(i).val += postOrder.get(i - 1).val;
        }
        return root;
    }
}
