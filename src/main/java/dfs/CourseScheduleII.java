package dfs;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseScheduleII {

    public boolean dfs(HashMap<Integer, HashSet<Integer>> deps, ArrayList<Integer> routine, HashSet<Integer> learned, int numCourse) {
        if (learned.size() == numCourse) {
            return true;
        }
        for (int i = 0; i < numCourse; i++) {
            // 没有学过这门课，但是学过了所有这门课的前置课程。
            if (!learned.contains(i) && (deps.get(i) == null || learned.containsAll(deps.get(i)))) {
                routine.add(i);
                learned.add(i);
                if (dfs(deps, routine, learned, numCourse)) {
                    return true;
                }
                routine.remove(routine.size() - 1);
                learned.remove(i);
            }
        }
        return false;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> deps = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < prerequisites.length; i++) {
            if (!deps.containsKey(prerequisites[i][0])) {
                deps.put(prerequisites[i][0], new HashSet<Integer>());
            }
            deps.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        ArrayList<Integer> routine = new ArrayList<Integer>();
        HashSet<Integer> learned = new HashSet<Integer>();

        dfs(deps, routine, learned, numCourses);

        if (routine.size() == numCourses) {
            int[] retArr = new int[routine.size()];
            for (int i = 0; i < routine.size(); i++) {
                retArr[i] = routine.get(i);
            }
            return retArr;
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Print.PrintArr(new CourseScheduleII().findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}));
        Print.PrintArr(new CourseScheduleII().findOrder(3, new int[][]{{1, 0}, {0, 1}}));
        Print.PrintArr(new CourseScheduleII().findOrder(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }
}
