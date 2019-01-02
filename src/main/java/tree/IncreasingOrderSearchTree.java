package tree;

import java.util.ArrayList;
import java.util.List;

public class IncreasingOrderSearchTree {

    public void inorderTravel(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTravel(list, root.left);
        list.add(root.val);
        inorderTravel(list, root.right);
    }


    public TreeNode increasingBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        inorderTravel(list, root);
        TreeNode newRoot = new TreeNode(list.get(0));
        TreeNode cur = newRoot;
        for (int i = 1; i < list.size(); i++) {
            cur.right = new TreeNode(list.get(i));
            cur = cur.right;
        }
        return newRoot;
    }
}
