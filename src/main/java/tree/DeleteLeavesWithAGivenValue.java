package tree;

class DeleteLeavesWithAGivenValue {

    public boolean shouldDelete(TreeNode node, int target) {
        if(node == null ) {
            return true;
        }
        return node.left == null && node.right == null && node.val == target;
    }
    
    public void postOrder(TreeNode root, int target) {
        if(root == null ) {
            return;
        }
        if(root.left != null) {
            postOrder(root.left, target);
        }
        if(root.right != null) {
            postOrder(root.right, target);
        }
        if(shouldDelete(root.left, target)) {
            root.left = null;
        }
        if(shouldDelete(root.right, target)) {
            root.right = null;
        }
    }

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        postOrder(root, target);
        if(root == null || shouldDelete(root, target)) {
            return null;
        }
        return root;
    }
}