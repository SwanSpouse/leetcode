package array;

import java.util.ArrayList;

public class IntervalListIntersections {

    public int[] mergeIntersection(int[] A, int[] B) {
        // 没有交集
        if (A[0] > B[1] || B[0] > A[1]) {
            return null;
        }
        // A包含B
        if (A[0] <= B[0] && B[1] <= A[1]) {
            return B;
        }
        // B包含A
        if (B[0] <= A[0] && A[1] <= B[1]) {
            return A;
        }
        // A在前，B在后
        if (A[0] <= B[0] && B[0] <= A[1]) {
            return new int[]{B[0], A[1]};
        }
        // B在前，A在后
        if (B[0] <= A[0] && A[0] <= B[1]) {
            return new int[]{A[0], B[1]};
        }
        return null;
    }

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        ArrayList<int[]> ret = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                int[] temp = mergeIntersection(A[i], B[j]);
                if (temp == null) {
                    continue;
                }
                ret.add(temp);
            }
        }
        int[][] finalRet = new int[ret.size()][2];
        for (int i = 0; i < ret.size(); i++) {
            finalRet[i][0] = ret.get(i)[0];
            finalRet[i][1] = ret.get(i)[1];
        }
        return finalRet;
    }

    // Input: A = [[0,2],[5,10],[13,23],[24,25]], B = [[1,5],[8,12],[15,24],[25,26]]
    public static void main(String[] args) {
        new IntervalListIntersections().intervalIntersection(
                new int[][]{{0, 2}, {5, 10}, {13, 23}, {24, 25}},
                new int[][]{{1, 5}, {8, 12}, {15, 24}, {25, 26}});
    }
}
