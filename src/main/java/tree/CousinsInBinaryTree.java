
package tree;


import java.util.*;

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }
        HashMap<Integer, Integer> nodeParent = new HashMap<>();
        HashMap<Integer, Integer> nodeLevel = new HashMap<>();

        ArrayList<TreeNode> cur ;
        ArrayList<TreeNode> next = new ArrayList<>();
        next.add(root);
        int level = 0;

        nodeParent.put(root.val, -1);
        nodeLevel.put(root.val, level);
        while(!next.isEmpty()) {
            level += 1;
            cur = new ArrayList<>(next);
            next.clear();
            for(int i =0; i < cur.size(); i ++ ) {
                if(cur.get(i).left != null) {
                    nodeParent.put(cur.get(i).left.val, cur.get(i).val);
                    nodeLevel.put(cur.get(i).left.val, level);
                    next.add(cur.get(i).left);
                }
                if(cur.get(i).right != null) {
                    nodeParent.put(cur.get(i).right.val, cur.get(i).val);
                    nodeLevel.put(cur.get(i).right.val, level);
                    next.add(cur.get(i).right);
                }
            }
        }
        return nodeLevel.get(x) == nodeLevel.get(y) && nodeParent.get(x) != nodeParent.get(y);
    }
}
