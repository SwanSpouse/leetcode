package detail;

public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        long max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            long cur = 0;
            for (int curPos = i, step = 0; step < A.length; step += 1, curPos += 1) {
                cur = cur + A[curPos % A.length] * step;
            }
            max = Math.max(max, cur);
        }
        return (int) max;
    }

    public static void main(String[] args) {
//        System.out.println(new RotateFunction().maxRotateFunction(new int[]{4, 3, 2, 6}));
        System.out.println(new RotateFunction().maxRotateFunction(new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE}));
    }
}
