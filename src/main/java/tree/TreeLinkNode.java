package tree;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "node:" + val;
    }
}
