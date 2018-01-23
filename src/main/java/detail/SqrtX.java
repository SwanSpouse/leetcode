package detail;

calss SqrtX {
    public static int mySqrt(int x) {
        if( x <= 1) {
            return x;
        }
        for(int i = 1; i <= x /2 + 1; i ++ ) {
            if( i *i <= x && (i + 1) * (i +1 ) > x ){
                return i;
            }
        }
        return -1;
    }
}
