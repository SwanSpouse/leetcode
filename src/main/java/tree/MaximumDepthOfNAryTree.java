package tree;

public class MaximumDepthOfNAryTree {
    public int maxDepth(Node root) {
        if(root == null) {
            return 0;
        }
        int depth = 0;
        for(Node node : root.children) {
            depth = Math.max(maxDepth(node), depth);
        }
        return depth + 1;
    }
}
