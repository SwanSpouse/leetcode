package tree;

import java.util.*;

// 要记住平衡二叉树的一个重要性质就是中序是有序的。好多题都可以转换为这个来解决。
public class RecoverBinarySearchTree {
	public void inorderTravel(List<TreeNode>tree, TreeNode cur) {
		if (cur == null) {
			return;
		}
		inorderTravel(tree, cur.left);
		tree.add(cur);
		inorderTravel(tree, cur.right);
	}

	public void recoverTree(TreeNode root) {
		List<TreeNode> tree = new ArrayList<TreeNode>();
		inorderTravel(tree, root);

		if(tree.size() <=1) {
			return ;
		}
		TreeNode left =null;
        TreeNode right =null;
		for (int i=0; i < tree.size()-1; i ++ ) {
			if (tree.get(i).val > tree.get(i+1).val ) {
				left = tree.get(i);
				break;
			}
		}
		for(int i=tree.size()-1; i >0; i -- ) {
			if(tree.get(i-1).val > tree.get(i).val) {
				right = tree.get(i);
				break;
			}
		}
		int temp = left.val;
		left.val = right.val;
		right.val = temp;
    }
}
