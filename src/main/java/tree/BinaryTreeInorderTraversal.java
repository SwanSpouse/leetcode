package tree;

import java.util.*;

public class BinaryTreeInorderTraversal {

    public static void inorderTraversal(List<Integer> ret, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(ret, root.left);
        ret.add(root.val);
        inorderTraversal(ret, root.right);
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ret = new ArrayList();
        inorderTraversal(ret, root);
        return ret;
    }
}
