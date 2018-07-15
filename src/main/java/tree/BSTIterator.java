package tree;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    int curIndex = 0;
    ArrayList<Integer> inorder;

    public void inorderTravel(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorderTravel(root.left, list);
        list.add(root.val);
        inorderTravel(root.right, list);
    }

    public BSTIterator(TreeNode root) {
        inorder = new ArrayList<Integer>();
        inorderTravel(root, inorder);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return curIndex < inorder.size();
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        return inorder.get(curIndex++);
    }
}
