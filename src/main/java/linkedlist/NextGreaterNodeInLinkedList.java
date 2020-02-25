package linkedlist;

import java.util.ArrayList;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }
        int[] ret = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            if (i > 0 && arr.get(i) > arr.get(i - 1) && arr.get(i) < ret[i - 1]) {
                ret[i] = ret[i - 1];
                continue;
            }
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(j) > arr.get(i)) {
                    ret[i] = arr.get(j);
                    break;
                }
            }
        }
        return ret;
    }
}
