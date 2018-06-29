package tree;


public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode generate(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right - left) / 2 + left;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generate(nums, left, mid - 1);
        node.right = generate(nums, mid + 1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return generate(nums, 0, nums.length - 1);
    }
}
