package linkedlist;

public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode faster = dummy;
        ListNode slower = dummy;

        for (int i = 0; i < n; i++) {
            faster = faster.next;
        }

        while (faster.next != null) {
            faster = faster.next;
            slower = slower.next;
        }

        slower.next = slower.next.next;
        return dummy.next;
    }
}
