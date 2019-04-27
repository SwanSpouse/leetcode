package detail;

public class FindTheTownJudge {
//    public int findJudge(int N, int[][] trust) {
//        if (N == 1) {
//            return 1;
//        }
//        HashMap<Integer, Set<Integer>> trustOthers = new HashMap<>();
//        HashMap<Integer, Set<Integer>> trusted = new HashMap<>();
//        for (int i = 0; i < trust.length; i++) {
//            // 相信别人
//            if (!trustOthers.containsKey(trust[i][0])) {
//                trustOthers.put(trust[i][0], new HashSet<>());
//            }
//            trustOthers.get(trust[i][0]).add(trust[i][1]);
//
//            // 被别人相信
//            if (!trusted.containsKey(trust[i][1])) {
//                trusted.put(trust[i][1], new HashSet<>());
//            }
//            trusted.get(trust[i][1]).add(trust[i][0]);
//        }
//
//        for (int i = 1; i <= N; i++) {
//            if (!trustOthers.containsKey(i) && trusted.containsKey(i) && trusted.get(i).size() == N - 1) {
//                return i;
//            }
//        }
//        return -1;
//    }

    public int findJudge(int N, int[][] trust) {
        int[] count = new int[N+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= N; ++i) {
            if (count[i] == N - 1) return i;
        }
        return -1;
    }
}
