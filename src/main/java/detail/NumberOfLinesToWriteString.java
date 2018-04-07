package detail;

/**
 * 细节题，简单题
 */
public class NumberOfLinesToWriteString {
    public int[] numberOfLines(int[] widths, String S) {
        if (S.length() == 0) {
            return new int[]{0, 0};
        }
        int curLineCounts = 1;
        int curLineUnitCounts = 0;

        for (int i = 0; i < S.length(); i++) {
            int curWidth = widths[S.charAt(i) - 'a'];
            if (curLineUnitCounts + curWidth <= 100) {
                curLineUnitCounts += curWidth;
            } else {
                curLineCounts += 1;
                curLineUnitCounts = curWidth;
            }
        }
        return new int[]{curLineCounts, curLineUnitCounts};
    }
}
