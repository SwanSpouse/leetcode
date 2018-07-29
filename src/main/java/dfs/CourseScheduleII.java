package dfs;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseScheduleII {


    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> deps = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][0];
            int to = prerequisites[i][1];
            if (!deps.containsKey(from)) {
                HashSet<Integer> set = new HashSet<Integer>();
                deps.put(from, set);
            }
            deps.get(from).add(to);
        }

        for (int startPos = 0; startPos < numCourses; startPos++) {
            ArrayList<Integer> ret = new ArrayList<Integer>();
            HashSet<Integer> learned = new HashSet<Integer>();
            HashSet<Integer> lastLearned;

            do {
                lastLearned = new HashSet<Integer>(learned);
                for (int i = startPos, count = 0; count < numCourses; i = (i + 1) % numCourses, count++) {
                    if (learned.contains(i)) {
                        continue;
                    }
                    boolean containsAllDeps = true;
                    if (deps.get(i) != null) {
                        for (Integer dep : deps.get(i)) {
                            if (!learned.contains(dep)) {
                                containsAllDeps = false;
                                continue;
                            }
                        }
                    }
                    if (containsAllDeps) {
                        ret.add(i);
                        learned.add(i);
                    }
                }

            } while (!(learned.containsAll(lastLearned) && lastLearned.containsAll(lastLearned)));

            if (learned.size() == numCourses) {
                int[] retArr = new int[ret.size()];
                for (int i = 0; i < ret.size(); i++) {
                    retArr[i] = ret.get(i);
                }
                return retArr;
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
//        Print.PrintArr(new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
//        Print.PrintArr(new CourseScheduleII().findOrder(3, new int[][]{{1, 0}, {0, 1}}));
        Print.PrintArr(new CourseScheduleII().findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }
}
