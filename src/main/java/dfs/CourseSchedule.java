package dfs;

import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {

    public boolean hasDepsCircle(HashMap<Integer, HashSet<Integer>> deps, int from, HashSet<Integer> routine) {
        if (deps.get(from) == null) {
            return false;
        }
        for (Integer needItem : deps.get(from)) {
            if (routine.contains(needItem)) {
                return true;
            }
            routine.add(needItem);
            if (hasDepsCircle(deps, needItem, routine)) {
                return true;
            }
            routine.remove(needItem);
        }
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> routine = new HashSet<Integer>();
            routine.add(i);
            if (hasDepsCircle(deps, i, routine)) {
                return false;
            }
            routine.remove(i);
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{0, 1}, {1, 0}}));
//        System.out.println(new CourseSchedule().canFinish(2, new int[][]{{0, 1}}));
        System.out.println(new CourseSchedule().canFinish(3, new int[][]{{0, 1}, {0, 2}, {2, 0}}));
    }
}
