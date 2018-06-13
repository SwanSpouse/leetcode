package tree;

import java.util.*;

public class ValidateBinarySearchTree {

	/** 当节点中存在一个Integer.MAX_VALUE或者Integer.MIN_VALUE的时候，可能会导致算法失效。
	* 所以现在试验一下中序遍历然后序列是升序。
 	*/
	// public boolean isValidBST(TreeNode root, int lower, int upper) {
	// 	if (root == null) {
	// 		return true ;
	// 	}
	// 	return root.val > lower && root.val < upper && isValidBST(root.left, lower, root.val) && isValidBST(root.right, root.val, upper);
	// }
	// public boolean isValidBST(TreeNode root) {
	// 	return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	// }

	public void inorderTravel(List<Integer> ret, TreeNode root) {
		if(root == null) {
			return ;
		}
		inorderTravel(ret, root.left);
		ret.add(root.val);
		inorderTravel(ret, root.right);
	}

	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true ;
		}
		List<Integer> list = new ArrayList<Integer>();
		inorderTravel(list, root);

		for(int i=1; i <list.size(); i ++ ) {
			if (list.get(i) <= list.get(i-1)) {
				return false;
			}
		}
		return true;
	}
}
