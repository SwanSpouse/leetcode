package linkedlist;

class ReverseNodesInKGroup {

    public static ListNode reverse(ListNode pre, ListNode tail) {
        if (pre == null || pre.next == null) {
            return pre;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = tail;
        ListNode head = pre.next;
        ListNode cur = pre.next;
        while (cur != null) {
            head = head.next;
            cur.next = dummy.next;
            dummy.next = cur;
            cur = head;
        }
        return dummy.next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {

    }
}