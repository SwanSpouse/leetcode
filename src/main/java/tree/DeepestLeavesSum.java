package tree;

import java.util.ArrayList;

class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        if(root == null) {
            return 0;
        }
        ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
        ArrayList<TreeNode> next = new ArrayList<TreeNode>();

        next.add(root);
        while(!next.isEmpty()){
            cur = new ArrayList<TreeNode>(next);
            next.clear();
            for(TreeNode node : cur) {
                if(node.left != null) {
                    next.add(node.left);
                }
                if(node.right != null) {
                    next.add(node.right);
                }
            }
        }
        int ret = 0;
        for(TreeNode node : cur) {
            ret += node.val;
        }
        return ret;
    }
}