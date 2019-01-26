package tree;


import static tree.Tree.constructTree;

public class ConstructStringFromBinaryTree {
    public void preOrder(TreeNode t, StringBuffer sb) {
        if (t == null) {
            return;
        }
        sb.append(t.val);
        if (t.left == null && t.right == null) {
            return;
        }
        sb.append("(");
        preOrder(t.left, sb);
        sb.append(")");

        if (t.right != null) {
            sb.append("(");
            preOrder(t.right, sb);
            sb.append(")");
        }
    }

    public String tree2str(TreeNode t) {
        StringBuffer sb = new StringBuffer();
        preOrder(t, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        TreeNode root = constructTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(new ConstructStringFromBinaryTree().tree2str(root));
    }
}
