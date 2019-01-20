package linkedlist;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int length = 0;
        for (ListNode cur = root; cur != null; cur = cur.next) {
            length += 1;
        }
        int[] count = new int[k];
        int left = length - length / k * k;
        for (int i = 0; i < k; i++) {
            count[i] = length / k;
            if (left > 0) {
                count[i] += 1;
                left -= 1;
            }
        }
        ListNode[] ret = new ListNode[k];
        ListNode cur = root;
        for (int i = 0; i < k; i++) {
            ret[i] = cur;
            if (count[i] > 0) {
                for (int j = 0; j < count[i] - 1; j++) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                cur.next = null;
                cur = next;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ListNode[] ret = new SplitLinkedListInParts().splitListToParts(LinkedList.constructLinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}), 3);
        for (int i = 0; i < ret.length; i++) {
            LinkedList.printLinkedList(ret[i]);
        }
    }
}
