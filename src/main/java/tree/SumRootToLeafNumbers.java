package tree;

public class SumRootToLeafNumbers {

	public void genNumbers(List<Integer> nums, int cur, TreeNode node) {
		if(node.left == null && node.right == null) {
			nums.add(cur * 10 + node.val);
			return ;
		}
		if(node.left != null) {
			genNumbers(nums, cur * 10 + node.val, node.left);
		}
		if (node.right != null) {
			genNumbers(nums, cur * 10 + node.val, node.right);
		}
	}

	public int sumNumbers(TreeNode root) {
		if(root == null) {
			return 0;
		}
		List<Integer> numList = new ArrayList<Integer>();
		genNumbers(numList, 0, node);

		int ret = 0;
		for(Integer val: numList) {
			ret += val;
		}
		return ret;
	}
}
