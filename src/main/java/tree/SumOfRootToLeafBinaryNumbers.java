package tree;

import java.util.ArrayList;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {

    public int convert(String input) {
        int ret = 0, bit = 1;
        for (int i = input.length() - 1; i >= 0; i--) {
            ret += input.charAt(i) == '1' ? bit : 0;
            bit *= 2;
        }
        return ret;
    }

    public void travel(List<Integer> paths, String cur, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            paths.add(convert(cur + node.val));
            return;
        }
        if (node.left != null) {
            travel(paths, cur + node.val, node.left);
        }
        if (node.right != null) {
            travel(paths, cur + node.val, node.right);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<Integer> paths = new ArrayList<>();
        travel(paths, "", root);

        int ret = 0;
        for (int i = 0; i < paths.size(); i++) {
            ret += paths.get(i);
        }
        return ret;
    }
}
