package sort_and_search;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] A) {
        int left = 0, right = A.length-1;
        while(left < right) {
            while(left < right && A[right] % 2 == 1) {
                right -= 1;
            }
            while(left < right && A[left] % 2 == 0) {
                left += 1;
            }
            int temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        return A;
    }
}
