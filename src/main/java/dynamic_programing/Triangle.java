package dynamic_programing;

import java.util.List;

public class Triangle {
    //  dp问题，自下而上 dp[i,j] = min(val[i,j] + min(dp[i+1, j], dp[i+1, j+1])
    public int minimumTotal(List<List<Integer>> triangle) {
        for (int row = triangle.size() - 2; row >= 0; row -= 1) {
            for (int line = 0; line <= row; line += 1) {
                int val = triangle.get(row).get(line) + Math.min(triangle.get(row + 1).get(line), triangle.get(row + 1).get(line + 1));
                triangle.get(row).set(line, val);
            }
        }
        return triangle.get(0).get(0);
    }
}
