package tree;

public class NAryTreePreorderTraversal {

    public void preorder(List<Integer> ret, Node root) {
        if(root == null) {
            return;
        }
        ret.add(root.val);
        for(Node cur : root.children) {
            preorder(ret, cur);
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        preorder(ret, root);
        return ret;
    }
}
