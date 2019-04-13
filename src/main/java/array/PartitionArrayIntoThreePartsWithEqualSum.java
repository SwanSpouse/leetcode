package array;

public class PartitionArrayIntoThreePartsWithEqualSum {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        if (sum % 3 != 0) {
            return false;
        }
        int part = 0, cnt = 0;
        for (int i = 0; i < A.length; i++) {
            part += A[i];
            if (part != sum / 3) {
                continue;
            }
            cnt += 1;
            if (cnt == 2) {
                return true;
            }
            part = 0;
        }
        return false;
    }
}
