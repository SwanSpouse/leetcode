package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree {

    public void markNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.val = root.val * 2;
            markNodes(root.left);
        }
        if (root.right != null) {
            root.right.val = root.val * 2 + 1;
            markNodes(root.right);
        }
    }

    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        root.val = 1;
        markNodes(root);

        List<TreeNode> cur = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        LinkedList<Integer> ret = new LinkedList<>();

        next.add(root);
        while (!next.isEmpty()) {
            cur = new ArrayList<>(next);
            next.clear();
            for (int i = 0; i < cur.size(); i++) {
                TreeNode curNode = cur.get(i);
                if (!ret.isEmpty() && curNode.val - ret.getLast() != 1) {
                    return false;
                }
                ret.addLast(curNode.val);
                if (curNode.left != null) {
                    next.add(curNode.left);
                }
                if (curNode.right != null) {
                    next.add(curNode.right);
                }
            }
        }
        return true;
    }

    public boolean isCompleteTree2(TreeNode root) {
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.offer(root);
        while (bfs.peek() != null) {
            TreeNode node = bfs.poll();
            bfs.offer(node.left);
            bfs.offer(node.right);
        }
        while (!bfs.isEmpty() && bfs.peek() == null)
            bfs.poll();
        return bfs.isEmpty();
    }
}
