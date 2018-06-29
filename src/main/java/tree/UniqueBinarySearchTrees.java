package tree;

import java.util.*;

/**
 * 递归的思想：
 * <p>
 * 当选取某个点为根的时候，左边有几个元素，右边有几个元素。
 * 然后左边、右边元素的排列方法就是子问题。
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        HashMap<Integer, Integer> countMap = new HashMap<Integer, Integer>();
        countMap.put(0, 1);
        countMap.put(1, 1);
        countMap.put(2, 3);
        countMap.put(3, 5);
        for (int i = 4; i <= n; i++) {
            int cur = 0;
            for (int j = 0; j < i; j++) {
                cur = cur + countMap.get(j) * countMap.get(i - 1 - j);
            }
            countMap.put(i, cur);
        }
        return countMap.get(n);
    }
}
