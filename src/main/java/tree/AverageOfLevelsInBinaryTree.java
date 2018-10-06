package tree;

public class AverageOfLevelsInBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ret = new ArrayList<Double>();
        if(root == null) {
            return ret;
        }
        List<TreeNode> cur = new ArrayList<TreeNode>();
        List<TreeNode> next = new ArrayList<TreeNode>();
        next.add(root);

        while(!next.isEmpty()) {
            cur = new ArrayList<TreeNode>(next);
            next.clear();
            double sum = 0;
            int count = 0;
            for(TreeNode node : cur) {
                sum += node.val;
                count += 1;
                if(node.left != null) {
                    next.add(node.left);
                }
                if(node.right != null) {
                    next.add(node.right);
                }
            }
            ret.add(sum / count);
        }
        return ret;
    }
}
