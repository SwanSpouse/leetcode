package tree;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    public TreeNode construct(int[] pre, int[] post, int preLeft, int preRight, int postLeft, int postRight) {
        if (preLeft > preRight) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preLeft]);
        if (preLeft == preRight) {
            return root;
        }
        int rootPostIndex = postLeft;
        while (post[rootPostIndex] != pre[preLeft + 1]) {
            rootPostIndex += 1;
        }
        int gap = rootPostIndex - postLeft;
        root.left = construct(pre, post, preLeft + 1, preLeft + 1 + gap, postLeft, rootPostIndex);
        root.right = construct(pre, post, preLeft + 1 + gap + 1, preRight, rootPostIndex + 1, postRight - 1);
        return root;
    }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return construct(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] post = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode root = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().constructFromPrePost(pre, post);
        Tree.levelOrderTravel(root);
    }
}
