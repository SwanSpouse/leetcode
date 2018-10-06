package tree;

public class LeafSimilarTrees {

    public void preorder(List<Integer> ret, TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            ret.add(root.val);
        }
        preorder(ret, root.left);
        preorder(ret, root.right);
    }

    public List<Integer> getAllLeaves(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        preorder(ret, root);
        return ret;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> ret1 = getAllLeaves(root1);
        List<Integer> ret2 = getAllLeaves(root2);

        for(int i=0; i < ret1.size() && i < ret2.size(); i ++) {
            if(ret1.get(i) != ret2.get(i)) {
                return false;
            }
        }
        return ret1.size() == ret2.size();
    }
}
