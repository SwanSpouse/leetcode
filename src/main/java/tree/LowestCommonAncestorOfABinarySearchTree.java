package tree;

public class LowestCommonAncestorOfABinarySearchTree {

//    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
//        if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
//        if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
//        return root;
//    }

    public boolean contains(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        } else if (node.val > root.val) {
            return contains(root.right, node);
        } else {
            return contains(root.left, node);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        boolean leftValid = contains(root.left, p) && contains(root.left, q);
        boolean rightValid = contains(root.right, p) && contains(root.right, q);

        if (!leftValid && !rightValid) {
            return root;
        } else if (leftValid && !rightValid) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (!leftValid && rightValid) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return null;
    }
}
