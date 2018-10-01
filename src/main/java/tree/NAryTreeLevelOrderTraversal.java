package tree;

public class NAryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null ) {
            return ret;
        }
        ArrayList<Node> cur = new ArrayList<Node>();
        ArrayList<Node> next = new ArrayList<Node>();
        next.add(root);
        while(!next.isEmpty()) {
            cur = new ArrayList<Node>(next);
            next.clear();
            ArrayList<Integer> curLevel = new ArrayList<Integer>();
            for(Node node : cur) {
                curLevel.add(node.val);
                for(Node child : node.children) {
                    next.add(child);
                }
            }
            ret.add(curLevel);
        }
        return ret;
    }
}
