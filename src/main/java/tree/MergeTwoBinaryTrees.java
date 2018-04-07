package tree;

public class MergeTwoBinaryTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }
        int val1 = t1 == null ? 0 : t1.val;
        int val2 = t2 == null ? 0 : t2.val;
        TreeNode root = new TreeNode(val1 + val2);

        if(t1 == null && t2 != null) {
            root.left  = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        } else if(t2 == null && t1 != null) {
            root.left  = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        } else if(t1 != null && t2 != null) {
            root.left  = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }
}