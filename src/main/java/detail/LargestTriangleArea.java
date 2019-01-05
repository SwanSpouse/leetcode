package detail;

public class LargestTriangleArea {

    public double largestTriangleArea(int[][] p) {
        double res = 0;
        for (int[] i : p)
            for (int[] j : p)
                for (int[] k : p)
                    res = Math.max(res, 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1] - j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new LargestTriangleArea().largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}, {3, 4}, {5, 2}, {1, 7}}));
//        System.out.println(new LargestTriangleArea().largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
//        System.out.println(new LargestTriangleArea().largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}}));
    }
}

