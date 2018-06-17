package tree;

public class PopulatingNextRightPointersInEachNodeII {

    public static void connectLevel(TreeLinkNode node) {
        if (node == null) {
            return;
        }
        TreeLinkNode lastNode = null;
        for (TreeLinkNode cur = node; cur != null; cur = cur.next) {
            if (cur.left == null && cur.right == null) {
                continue;
            } else if (cur.left == null && cur.right != null) {
                if (lastNode == null) {
                    lastNode = cur.right;
                } else {
                    lastNode.next = cur.right;
                    lastNode = lastNode.next;
                }
            } else if (cur.left != null && cur.right == null) {
                if (lastNode == null) {
                    lastNode = cur.left;
                } else {
                    lastNode.next = cur.left;
                    lastNode = lastNode.next;
                }
            } else if (cur.left != null && cur.right != null) {
                if (lastNode == null) {
                    lastNode = cur.left;
                    lastNode.next = cur.right;
                    lastNode = lastNode.next;
                } else {
                    lastNode.next = cur.left;
                    lastNode = lastNode.next;
                    lastNode.next = cur.right;
                    lastNode = lastNode.next;
                }
            }
        }
    }

    public static TreeLinkNode getNextLevelFirstNode(TreeLinkNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return getNextLevelFirstNode(root.next);
        }
        return root.left != null ? root.left : root.right;
    }

    public static void connect(TreeLinkNode root) {
        for (TreeLinkNode cur = root; cur != null; cur = getNextLevelFirstNode(cur)) {
            connectLevel(cur);
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = Tree.constructLinkTree(new char[]{'3', '9', '1', '#', '#', '5', '7'});
        connect(root);

        for (TreeLinkNode cur = root; cur != null; cur = getNextLevelFirstNode(cur)) {
            for (TreeLinkNode node = cur; node != null; node = node.next) {
                System.out.printf("%d->", node.val);
            }
            System.out.println();
        }
    }

}
