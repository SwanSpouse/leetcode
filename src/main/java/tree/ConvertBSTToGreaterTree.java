package tree;

import java.util.ArrayList;
import java.util.List;

public class ConvertBSTToGreaterTree {

    public void inorder(List<TreeNode> nodes, TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(nodes, root.left);
        nodes.add(root);
        inorder(nodes, root.right);
    }

    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        inorder(nodes, root);
        for (int i = nodes.size() - 2; i >= 0; i--) {
            nodes.get(i).val += nodes.get(i + 1).val;
        }
        return root;
    }
}
