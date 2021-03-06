package graph;

import java.util.*;

public class MinimumHeightTrees {

    //    public int calHeight(HashMap<Integer, List<Integer>> edgeMap, int[] visited, int root) {
//        List<Integer> next = new ArrayList<>();
//        next.add(root);
//        visited[root] = 1;
//        int height = 0;
//        while (!next.isEmpty()) {
//            List<Integer> curList = new ArrayList<>(next);
//            next.clear();
//            height += 1;
//            for (Integer curNode : curList) {
//                if (!edgeMap.containsKey(curNode)) {
//                    continue;
//                }
//                for (Integer child : edgeMap.get(curNode)) {
//                    if (visited[child] == 1) {
//                        continue;
//                    }
//                    visited[child] = 1;
//                    next.add(child);
//                }
//            }
//        }
//        return height;
//    }
//
//    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
//        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
//        for (int i = 0; i < edges.length; i++) {
//            int node1 = edges[i][0];
//            int node2 = edges[i][1];
//            if (!edgeMap.containsKey(node1)) {
//                edgeMap.put(node1, new ArrayList<>());
//            }
//            edgeMap.get(node1).add(node2);
//            if (!edgeMap.containsKey(node2)) {
//                edgeMap.put(node2, new ArrayList<>());
//            }
//            edgeMap.get(node2).add(node1);
//        }
//
//        HashMap<Integer, Integer> height = new HashMap<>();
//        int minHeight = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            int curHeight = calHeight(edgeMap, new int[n], i);
//            height.put(i, curHeight);
//            minHeight = Math.min(minHeight, curHeight);
//        }
//
//        List<Integer> ret = new ArrayList<>();
//        for (int key : height.keySet()) {
//            if (height.get(key) == minHeight) {
//                ret.add(key);
//            }
//        }
//        return ret;
//    }

    // 不断的拿走度数为1的节点，剩下的一个或者两个节点就是答案。
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) return Collections.singletonList(0);

        List<Set<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; ++i) adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; ++i)
            if (adj.get(i).size() == 1) leaves.add(i);

        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int i : leaves) {
                int j = adj.get(i).iterator().next();
                adj.get(j).remove(i);
                if (adj.get(j).size() == 1) newLeaves.add(j);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumHeightTrees().findMinHeightTrees(1, new int[][]{}));
//        System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, new int[][]{
//                {1, 0}, {1, 2}, {1, 3}
//        }));
//        System.out.println(new MinimumHeightTrees().findMinHeightTrees(6, new int[][]{
//                {0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}
//        }));
    }
}

