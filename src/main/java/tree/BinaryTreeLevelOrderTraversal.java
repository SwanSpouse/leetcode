package tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		ArrayList<TreeNode> cur = new ArrayList<TreeNode>();
		ArrayList<TreeNode> next = new ArrayList<TreeNode>();
		next.add(root);
		while(!next.isEmpty()) {
			cur = new ArrayList<TreeNode>(next);
			next.clear();
			List<Integer> vals = new ArrayList<Integer>();
			for(TreeNode item : cur) {
				if(item == null) {
					continue;
				}
				vals.add(item.val);
				next.add(item.left);
				next.add(item.right);
			}
			if(!vals.isEmpty()) {
				ret.add(new ArrayList<Integer>(vals));
			}
		}
		return ret;
	}
}
