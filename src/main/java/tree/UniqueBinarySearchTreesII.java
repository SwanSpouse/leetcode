package tree;

import java.util.*;

/**
 * 这道题不错。想了好久，最后还是看答案做出来的
 */
public class UniqueBinarySearchTreesII {

	public static List<TreeNode> generate(int lower, int upper) {
		if(lower > upper) {
			ArrayList<TreeNode> node = new ArrayList<TreeNode>();
			node.add(null);
			return node;
		}
		List<TreeNode> cur = new ArrayList<TreeNode>();
		for (int i =lower; i <= upper; i ++ ) {
			List<TreeNode> leftNodes = generate(lower, i-1);
			List<TreeNode> rightNodes  = generate(i+1, upper);

			for(TreeNode left : leftNodes) {
				for (TreeNode right : rightNodes) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					cur.add(node);
				}
			}
		}
		return cur;
	}
	public static List<TreeNode> generateTrees(int n) {
		if (n==0) {
			return new ArrayList<TreeNode>();
		}
		return generate(1,n);
    }

    public static void main(String[] args) {
		List<TreeNode> trees = generateTrees(3);

		for (TreeNode root : trees) {
			Tree.levelOrderTravel(root);
			System.out.println();
		}
	}
}
