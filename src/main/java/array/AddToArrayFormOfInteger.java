package array;

import utils.Print;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> ret = new LinkedList<>();

        int index = A.length - 1;
        int carry = 0;
        while (index >= 0 || K > 0) {
            int cur = K % 10 + carry;
            if (index >= 0) {
                cur += A[index--];
            }
            carry = cur / 10;
            cur = cur % 10;
            ret.addFirst(cur);
            K = K / 10;
        }

        if (carry != 0) {
            ret.addFirst(carry);
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printList(new AddToArrayFormOfInteger().addToArrayForm(new int[]{2, 1, 5}, 806));
        Print.printList(new AddToArrayFormOfInteger().addToArrayForm(new int[]{9, 9, 9, 9}, 806));
    }
}
