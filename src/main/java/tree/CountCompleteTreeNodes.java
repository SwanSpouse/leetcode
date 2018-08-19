package tree;

import static tree.Tree.constructTree;

/**
 * https://www.cnblogs.com/lailailai/p/4558393.html
 */

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int hl = 1, hr = 1;
        for (TreeNode left = root.left; left != null; hl += 1, left = left.left) ;
        for (TreeNode right = root.right; right != null; hr += 1, right = right.right) ;

        if (hl == hr) {
            return (int) Math.pow(2, hl) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = constructTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }
}
