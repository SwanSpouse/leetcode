package dynamic_programing;

public class CompletePackageProblem {
    // 完全背包 完全背包问题可以转化为01背包问题。
    public int solution(int[] w, int[] v, int W) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = W; j >= w[i]; j--) {
                for (int time = 0; j >= time * w[i]; time += 1) {
                    dp[j] = Math.max(dp[j], dp[j - time * w[i]] + time * v[i]);
                }
            }
        }
        return dp[W];
    }

    public static void main(String[] args) {
        int[] w = new int[]{3, 5, 7, 9};
        int[] c = new int[]{3, 5, 7, 9};
        int W = 13;
        System.out.println(new PackageProblem01().solution(w, c, W));
    }
}
