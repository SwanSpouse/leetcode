package tree;

public class PopulatingNextRightPointersInEachNode {

    public void connectLevel(TreeLinkNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return;
        }
        for (TreeLinkNode cur = node; cur != null; cur = cur.next) {
            cur.left.next = cur.right;
            if (cur.next != null) {
                cur.right.next = cur.next.left;
            }
        }
    }

    public void connect(TreeLinkNode root) {
        for (TreeLinkNode cur = root; cur != null; cur = cur.left) {
            connectLevel(cur);
        }
    }
}
