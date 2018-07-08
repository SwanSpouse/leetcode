package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public void postOrder(TreeNode root, List<Integer> ret) {
        if (root == null) {
            return;
        }
        postOrder(root.left, ret);
        postOrder(root.right, ret);
        ret.add(root.val);
    }


    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        postOrder(root, ret);
        return ret;
    }
}
