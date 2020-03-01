package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class DeleteNodesAndReturnForest {

    public void dfs(TreeNode father, boolean fromLeft, boolean createANewTree, TreeNode node, List<TreeNode> ret, HashSet<Integer> toDeletes) {
        if (node == null) {
            return;
        }
        // 把自己从树中摘出去
        if (toDeletes.contains(node.val)) {
            if (father != null) {
                father.left = fromLeft ? null : father.left;
                father.right = !fromLeft ? null : father.right;
            }
            dfs(node, true, true, node.left, ret, toDeletes);
            dfs(node, false, true, node.right, ret, toDeletes);
        } else {
            if (createANewTree) {
                ret.add(node);
            }
            dfs(node, true, false, node.left, ret, toDeletes);
            dfs(node, false, false, node.right, ret, toDeletes);
        }
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }
        HashSet<Integer> toDeletes = new HashSet<>();
        for (int i = 0; i < to_delete.length; i++) {
            toDeletes.add(to_delete[i]);
        }
        dfs(null, true, true, root, ret, toDeletes);
        return ret;
    }
}
