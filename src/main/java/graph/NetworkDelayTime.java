package graph;

import java.util.HashMap;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int N, int K) {
        HashMap<Integer, Integer> targetDelay = new HashMap<>();
        for (int i = 0; i < N; i++) {
            targetDelay.put(i, times[i][N]);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    continue;
                }
                if (targetDelay.get(i) + times[i][j] < targetDelay.get(j)) {
                    targetDelay.put(j, targetDelay.get(i) + times[i][j]);
                }
            }
        }
        return targetDelay.get(K);
    }
}
