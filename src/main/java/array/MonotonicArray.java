package array;

public class MonotonicArray {
    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        boolean increasing = false;
        boolean foundRules = false;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] != A[i] && !foundRules) {
                foundRules = true;
                increasing = A[i - 1] < A[i];
            }
            if (foundRules) {
                if ((increasing && A[i - 1] > A[i]) || (!increasing && A[i - 1] < A[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isMonotonic2(int[] A) {
        boolean inc = true, dec = true;
        for (int i = 1; i < A.length; ++i) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }

    public static void main(String[] args) {
        System.out.println(new MonotonicArray().isMonotonic(new int[]{1, 3, 2}));
    }
}
