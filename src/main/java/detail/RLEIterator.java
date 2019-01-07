package detail;

public class RLEIterator {
    int index;
    int[] A;

    public RLEIterator(int[] A) {
        this.A = A;
        index = 0;
    }

    public int next(int n) {
        while (index < A.length && n > A[index]) {
            n = n - A[index];
            index += 2;
        }

        if (index >= A.length) {
            return -1;
        }

        A[index] = A[index] - n;
        return A[index + 1];
    }

    public static void main(String[] args) {
        RLEIterator it = new RLEIterator(new int[]{3, 8, 0, 9, 2, 5});
        System.out.println(it.next(2));
        System.out.println(it.next(1));
        System.out.println(it.next(1));
        System.out.println(it.next(2));
        System.out.println(it.next(2));
    }
}
