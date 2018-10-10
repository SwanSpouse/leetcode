package tree;

import java.util.ArrayList;
import java.util.List;

public class TwoSumIV {

    public void inorder(List<Integer> vals, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(vals, root.left);
        vals.add(root.val);
        inorder(vals, root.right);
    }

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> vals = new ArrayList<Integer>();
        inorder(vals, root);
        for (int i = 0, j = vals.size() - 1; i < j; ) {
            int cur = vals.get(i) + vals.get(j);
            if (cur == k) {
                return true;
            } else if (cur > k) {
                j -= 1;
            } else {
                i += 1;
            }
        }
        return false;
    }
}
