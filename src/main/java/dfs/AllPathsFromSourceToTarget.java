package dfs;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    public void dfs(int[][] graph, List<List<Integer>> ret, List<Integer> cur, int curNode) {
        if (curNode == graph.length - 1) {
            ret.add(new ArrayList<>(cur));
            return;
        } else if (curNode >= graph.length || graph[curNode].length == 0) {
            return;
        }
        for (int j = 0; j < graph[curNode].length; j++) {
            int next = graph[curNode][j];
            cur.add(next);
            dfs(graph, ret, cur, next);
            cur.remove(cur.size() - 1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        if (graph.length == 0) {
            return ret;
        }
        List<Integer> cur = new ArrayList<>();
        cur.add(0);
        dfs(graph, ret, cur, 0);
        return ret;
    }

    public static void main(String[] args) {
        Print.print2DIntegerList(new AllPathsFromSourceToTarget().allPathsSourceTarget(new int[][]{
                {1, 2}, {3}, {3}, {},
        }));
    }
}
