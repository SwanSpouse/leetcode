package array;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] A) {
        int count = 0;
        for (int i = 0; i < A[0].length(); i++) {
            for (int j = 1; j < A.length; j++) {
                if (A[j - 1].charAt(i) > A[j].charAt(i)) {
                    count += 1;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(new String[]{"cba", "daf", "ghi"}));
    }
}
