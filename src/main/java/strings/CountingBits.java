package strings;

import utils.Print;

public class CountingBits {
    public int[] countBits(int num) {
        int[] ret = new int[num + 1];
        ret[0] = 0;
        int cur = 1;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                ret[i] = 1;
                continue;
            }
            if (i == cur << 1) {
                ret[i] = 1;
                cur = cur << 1;
                continue;
            }
            ret[i] = ret[cur] + ret[i - cur];
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new CountingBits().countBits(17));
    }
}
