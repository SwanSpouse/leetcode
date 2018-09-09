package detail;

public class HIndex {
    public int hIndex(int[] citations) {
        for (int i = citations.length - 1; i >= 0; i--) {
            int N = i + 1;
            int countN = 0;
            for (int j = 0; j < citations.length; j++) {
                if (citations[j] >= N) {
                    countN += 1;
                }
                if (countN >= N) {
                    break;
                }
            }
            if (countN >= N) {
                return N;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new HIndex().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new HIndex().hIndex(new int[]{10, 12}));
    }
}
