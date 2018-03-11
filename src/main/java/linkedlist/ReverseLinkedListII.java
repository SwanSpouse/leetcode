package linkedlist;

/**
 * 分成3段来进行处理。0~m, m~n, n ~ length
 */
public class ReverseLinkedListII {

    public static ListNode reverse(ListNode head, int len) {
        if (len <= 0 || head == null) {
            return head;
        }
        ListNode newTail = head;
        ListNode cur = head;
        ListNode dummy = new ListNode(-1);

        for (int i = 0; i <= len; i++) {
            cur = cur.next;
            head.next = dummy.next;
            dummy.next = head;
            head = cur;
        }
        newTail.next = head;
        return dummy.next;
    }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode pre;
        dummy.next = head;

        pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        pre.next = reverse(pre.next, n - m);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{1, 2, 3, 4, 5});
//        LinkedList.printLinkedList(reverseBetween(head, 2, 4));
//        LinkedList.printLinkedList(reverseBetween(head, 1, 5));
        LinkedList.printLinkedList(reverseBetween(head, 2, 3));
//        LinkedList.printLinkedList(reverseBetween(head, 2, 2));
    }

}