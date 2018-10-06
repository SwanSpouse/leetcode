package tree;

public class NAryTreePostorderTraversal {

    public void postorder(List<Integer> ret, Node root) {
        if(root == null) {
            return;
        }
        for(Node node : root.children) {
            postorder(ret, node);
        }
        ret.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ret = new ArrayList<Integer>();
        postorder(ret, root);
        return ret;
    }
}
