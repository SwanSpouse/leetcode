package tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> cur = new LinkedList<TreeNode>();
        LinkedList<TreeNode> next = new LinkedList<TreeNode>();
		next.add(root);
		while(!next.isEmpty()) {
			cur = new LinkedList<TreeNode>(next);
			next.clear();
			List<Integer> vals = new LinkedList<Integer>();
			for(TreeNode item : cur) {
				if(item == null) {
					continue;
				}
				vals.add(item.val);
				next.add(item.left);
				next.add(item.right);
			}
			if(!vals.isEmpty()) {
				ret.addFirst(new LinkedList<Integer>(vals));
			}
		}
		return ret;
	}
}
