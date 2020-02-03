package tree;

import java.util.ArrayList;
import java.util.List;

public class AllElementsInTwoBinarySearchTrees {

    public void inOrder(TreeNode root, List<Integer> order) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inOrder(root.left, order);
        }
        order.add(root.val);
        if (root.right != null) {
            inOrder(root.right, order);
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> order1 = new ArrayList<>();
        ArrayList<Integer> order2 = new ArrayList<>();

        inOrder(root1, order1);
        inOrder(root2, order2);

        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0, j = 0; i < order1.size() || j < order2.size(); ) {
            int cur1 = i < order1.size() ? order1.get(i) : Integer.MAX_VALUE;
            int cur2 = j < order2.size() ? order2.get(j) : Integer.MAX_VALUE;

            if (cur1 <= cur2) {
                ret.add(cur1);
                i++;
            } else {
                ret.add(cur2);
                j++;
            }
        }
        return ret;
    }
}
