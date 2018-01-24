package detail;

/**
 * 这题的考点就在于那个越界的判断。要大概知道Java int的最大值大约是21亿左右。
 */ 
class SqrtX {
    public static int mySqrt(int x) {
        if( x <= 1) {
            return x;
        }
        for(int i = 1; i <= x /2 + 1; i ++ ) {
            if( i * i <= x && (x < (i + 1) * (i + 1)) || (i + 1) * (i +1 ) < 0 ){
                return i;
            }
        }
        return -1;
    }
}
