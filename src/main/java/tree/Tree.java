package tree;

import java.util.ArrayList;

class Tree {

    private Tree() {
    }

    public static TreeNode constructTree(int[] input) {
        return newTreeNodeFromArray(input, 0);
    }

    public static TreeNode constructTree(char[] input) {
        return newTreeNodeFromArray(input, 0);
    }


    public static TreeNode newTreeNodeFromArray(int[] input, int pos) {
        if (input.length == 0 || pos >= input.length) {
            return null;
        }
        TreeNode root = new TreeNode(input[pos]);
        int left = (pos + 1) * 2 - 1;
        int right = (pos + 1) * 2;
        root.left = newTreeNodeFromArray(input, left);
        root.right = newTreeNodeFromArray(input, right);
        return root;
    }

    public static TreeNode newTreeNodeFromArray(char[] input, int pos) {
        if (input.length == 0 || pos >= input.length || input[pos] == '#') {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(input[pos] + ""));
        int left = (pos + 1) * 2 - 1;
        int right = (pos + 1) * 2;
        root.left = newTreeNodeFromArray(input, left);
        root.right = newTreeNodeFromArray(input, right);
        return root;
    }

    public static void levelOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        ArrayList<TreeNode> curLevel = new ArrayList<TreeNode>();
        ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
        nextLevel.add(root);

        while (!nextLevel.isEmpty()) {
            curLevel.addAll(nextLevel);
            nextLevel.clear();
            for (TreeNode cur : curLevel) {
                if (cur == null) {
                    continue;
                }
                System.out.print(cur.val + " ");
                nextLevel.add(cur.left);
                nextLevel.add(cur.right);
            }
            curLevel.clear();
        }
    }

    public static void preOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    public static void inOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTravel(root.left);
        System.out.print(root.val + " ");
        inOrderTravel(root.right);
    }

    public static void postOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTravel(root.left);
        postOrderTravel(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        preOrderTravel(constructTree(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println();
        inOrderTravel(constructTree(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println();
        postOrderTravel(constructTree(new int[]{1, 2, 3, 4, 5, 6}));
        System.out.println();

        levelOrderTravel(constructTree(new char[]{'1', '2', '3', '#', '#', '6'}));
    }
}