package detail;

import utils.Print;

import java.util.ArrayList;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {
    static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }

    public int binarySearch(CustomFunction f, int x, int z) {
        int left = 1, right = 1000;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int cur = f.f(x, mid);
            if (cur == z) {
                return mid;
            } else if (cur > z) {
                right = mid - 1;
            } else if (cur < z) {
                left = mid + 1;
            }
        }
        return -1;
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        ArrayList<List<Integer>> ret = new ArrayList<>();
        for (int x = 1; x <= 1000; x++) {
            int y = binarySearch(customfunction, x, z);
            if (y != -1) {
                ArrayList<Integer> cur = new ArrayList<>();
                cur.add(x);
                cur.add(y);
                ret.add(cur);
                continue;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.print2DIntegerList(new FindPositiveIntegerSolutionForAGivenEquation().findSolution(new CustomFunction(), 5));
    }
}
