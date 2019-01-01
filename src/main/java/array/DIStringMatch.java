package array;

import utils.Print;

public class DIStringMatch {
    public int[] diStringMatch(String S) {
        if (S.length() == 0) {
            return new int[]{0};
        }
        int[] ret = new int[S.length() + 1];
        int min = 0, max = S.length();

        for (int i = 0; i < ret.length; i++) {
            if (i == ret.length - 1) {
                ret[i] = min;
            } else if (S.charAt(i) == 'I') {
                ret[i] = min++;
            } else if (S.charAt(i) == 'D') {
                ret[i] = max--;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new DIStringMatch().diStringMatch("IDID"));
        Print.printArr(new DIStringMatch().diStringMatch("III"));
        Print.printArr(new DIStringMatch().diStringMatch("DDI"));
        Print.printArr(new DIStringMatch().diStringMatch(""));
    }
}
