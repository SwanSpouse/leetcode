package array;


public class ValidMountainArray {
    public boolean validMountainArray(int[] A) {
        if(A.length <= 2) {
            return false;
        }
        boolean meetTop = false;
        for(int i = 1; i < A.length; i ++ ) {
            if((i == 1 && A[0] > A[1]) || A[i-1] == A[i]) {
                return false;
            } else if(A[i-1] > A[i] && !meetTop ) {
                meetTop = true;
            } else if(meetTop && A[i-1] <= A[i]) {
                return false;
            }
        }
        return meetTop ;
    }
}
