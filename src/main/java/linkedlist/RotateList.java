package linkedlist;


/**
 * 简单题，快慢指针。
 * 比较费劲的地方是K可能超过链表的长度。
 * <p>
 * 居然超时了。还是要先计算一下总体长度。然后再进行计算。
 */
class RotateList {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;
        for (ListNode cur = head; cur != null; cur = cur.next, len += 1) ;
        k = k % len;
        for (int i = 0; i < k; i++) {
            fast = fast.next == null ? head : fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        if (slow.next == null) {
            return head;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{1, 2, 3, 4, 5});
        LinkedList.printLinkedList(rotateRight(head, 10));
    }
}