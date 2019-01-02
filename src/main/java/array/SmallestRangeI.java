package array;

public class SmallestRangeI {
    public int smallestRangeI(int[] A, int K) {
        if (A.length == 1) {
            return 0;
        }
        int min = A[0];
        int max = A[0];
        for (int i = 1; i < A.length; i++) {
            min = Math.min(min, A[i]);
            max = Math.max(max, A[i]);
        }
        int minRangeMax = min + Math.abs(K), maxRangeMin = max - Math.abs(K);
        return minRangeMax > maxRangeMin ? 0 : Math.abs(minRangeMax - maxRangeMin);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{0, 10}, 2));
        System.out.println(new SmallestRangeI().smallestRangeI(new int[]{1, 3, 6}, 3));
    }
}
