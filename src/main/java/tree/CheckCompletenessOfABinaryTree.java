package tree;

public class CheckCompletenessOfABinaryTree {

    public boolean isCompleteTree(TreeNode root) {
        if(root == null) {
            return true;
        }
        List<TreeNode> current = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();
        next.add(root);

        while(!next.isEmpty()) {
            current = new ArrayList<TreeNode>(next);
            next.clear();
            for(int i =0; i < current.size(); i ++ ) {
                TreeNode curNode = current.get(i);
                if( next.isEmpty() && i == current.size()-1 && curNode.right != null && curNode.left == null ) {
                    return false;
                }
                if( !(next.isEmpty() && i == current.size()-1) && (curNode.left == null || curNode.right == null)) {
                    return false;
                }
                if(curNode.left != null) {
                    next.add(curNode.left);
                }
                if(curNode.right != null) {
                    next.add(curNode.right);
                }
            }
        }
        return true;
    }
}
