package tree;

public class DeleteNodeInABST {

    public void addNode(TreeNode target, TreeNode node) {
        if (node == null) {
            return;
        }
        TreeNode cur = target;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = node;
    }

    public TreeNode searchParentNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val < key) {
            if (root.right != null && root.right.val == key) {
                return root;
            }
            return searchParentNode(root.right, key);
        } else if (root.val > key) {
            if (root.left != null && root.left.val == key) {
                return root;
            }
            return searchParentNode(root.left, key);
        }
        return null;
    }

    public void deleteNodeThroughParent(TreeNode parent, int key) {
        if (parent.left != null && parent.left.val == key) {
            TreeNode target = parent.left;
            if (target.left != null) {
                parent.left = target.left;
                addNode(parent.left, target.right);
            } else {
                parent.left = target.right;
            }
        } else if (parent.right != null && parent.right.val == key) {
            TreeNode target = parent.right;
            if (target.left != null) {
                parent.right = target.left;
                addNode(parent.right, target.right);
            } else {
                parent.right = target.right;
            }
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left != null) {
                addNode(root.left, root.right);
                return root.left;
            } else {
                return root.right;
            }
        }
        TreeNode parent = searchParentNode(root, key);
        if (parent == null) {
            return root;
        }
        deleteNodeThroughParent(parent, key);
        return root;
    }

    public static void main(String[] args) {
        for (int i : new int[]{5, 3, 6, 2, 4, 7}) {
            TreeNode root = Tree.constructTree(new char[]{'5', '3', '6', '2', '4', '#', '7'});
            Tree.levelOrderTravel(new DeleteNodeInABST().deleteNode(root, i));
            System.out.println();
        }
    }
}
