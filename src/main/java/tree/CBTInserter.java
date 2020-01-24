package tree;


import java.util.LinkedList;

public class CBTInserter {

    private TreeNode root;

    public CBTInserter(TreeNode root) {
        this.root = root;
    }

    public int insert(int v) {
        LinkedList<TreeNode> list = new LinkedList<TreeNode>();
        list.add(this.root);

        TreeNode cur;
        while (true) {
            cur = list.pollFirst();
            if (cur.left == null) {
                cur.left = new TreeNode(v);
                return cur.val;
            } else if (cur.right == null) {
                cur.right = new TreeNode(v);
                return cur.val;
            }
            if (cur.left != null) {
                list.addLast(cur.left);
            }
            if (cur.right != null) {
                list.addLast(cur.right);
            }
        }
    }

    public TreeNode get_root() {
        return this.root;
    }
}
