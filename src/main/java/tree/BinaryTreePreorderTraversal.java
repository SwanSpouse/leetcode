package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {

    public void preOrder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        ret.add(root.val);
        preOrder(root.left, ret);
        preOrder(root.right, ret);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        preOrder(root, ret);
        return ret;
    }
}
