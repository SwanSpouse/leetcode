package dynamic_programing;

public class PackageProblem01 {


    // 01背包
    public int solution(int[] w, int[] v, int W) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = W; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - w[i]] + v[i]);
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] w = new int[]{1, 3, 5, 7, 8};
        int[] c = new int[]{1, 3, 5, 7, 8};
        int W = 10;
        System.out.println(new PackageProblem01().solution(w, c, W));
    }
}
