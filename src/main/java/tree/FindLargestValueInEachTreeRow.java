package tree;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

import static tree.Tree.constructTree;

public class FindLargestValueInEachTreeRow {

    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        next.add(root);

        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
            next.clear();
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < cur.size(); i++) {
                TreeNode curNode = cur.get(i);
                max = Math.max(max, curNode.val);
                if (curNode.left != null) {
                    next.add(curNode.left);
                }
                if (curNode.right != null) {
                    next.add(curNode.right);
                }
            }
            ret.add(max);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode root = constructTree(new int[]{1, 3, 2, 5, 3, 9});
        Print.printList(new FindLargestValueInEachTreeRow().largestValues(root));
    }
}
