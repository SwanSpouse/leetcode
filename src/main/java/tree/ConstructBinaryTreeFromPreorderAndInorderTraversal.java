package tree;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode generate(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRright) {
        if (preLeft > preRight) {
            return null;
        }
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        int rootPos = inLeft;
        for (int i = inLeft; i <= inRright; i++) {
            if (inorder[i] == rootVal) {
                rootPos = i;
                break;
            }
        }
        root.left = generate(preorder, inorder, preLeft + 1, preLeft + rootPos - inLeft, inLeft, rootPos - 1);
        root.right = generate(preorder, inorder, preLeft + rootPos - inLeft + 1, preRight, rootPos + 1, inRright);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return generate(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
}
