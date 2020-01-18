package detail;

class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int[] ret = new int[n];
        for(int i = 0; i + 1 < n; i +=2 ) {
            ret[i] = i+1;
            ret[i+1] = -(i+1);
        }
        if (n % 2 == 1) {
            ret[n-1] = 0 ;
        }
        return ret;
    }
}