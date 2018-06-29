
package tree;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode generate(int[] postorder, int[] inorder, int postLeft, int postRight, int inLeft, int inRright) {
        if (postLeft > postRight) {
            return null;
        }
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        int rootPos = inLeft;
        for (int i = inLeft; i <= inRright; i++) {
            if (inorder[i] == rootVal) {
                rootPos = i;
                break;
            }
        }
        root.left = generate(postorder, inorder, postLeft, postLeft + rootPos - inLeft - 1, inLeft, rootPos - 1);
        root.right = generate(postorder, inorder, postLeft + rootPos - inLeft, postRight - 1, rootPos + 1, inRright);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return generate(postorder, inorder, 0, postorder.length - 1, 0, inorder.length - 1);
    }
}
