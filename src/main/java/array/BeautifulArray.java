package array;

import utils.Print;

public class BeautifulArray {

    public int[] beautifulArray(int N) {
        int[] ret = new int[N];
        for (int i = 1; i <= N; i += 2) {
            ret[i - 1] = i + 1;
            if (i < N) {
                ret[i] = i;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new BeautifulArray().beautifulArray(4));
    }
}
