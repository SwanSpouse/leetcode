package tree;

public class MaximumBinaryTree {

    public TreeNode construct(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        } else if (left == right) {
            return new TreeNode(nums[left]);
        }
        int maxIndex = left;
        int max = nums[left];
        for (int i = left; i <= right; i++) {
            if (nums[i] > max) {
                maxIndex = i;
                max = nums[i];
            }
        }
        TreeNode node = new TreeNode(max);
        node.left = construct(nums, left, maxIndex - 1);
        node.right = construct(nums, maxIndex + 1, right);
        return node;
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }
}
