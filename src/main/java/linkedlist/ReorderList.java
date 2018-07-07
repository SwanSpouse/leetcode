package linkedlist;

public class ReorderList {

    public static ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }

    public static void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;

        ListNode cur = head;
        ListNode cur1 = head.next;
        ListNode cur2 = reverse(secondHalf);
        ;
        while (cur1 != null || cur2 != null) {
            if (cur2 != null) {
                cur.next = cur2;
                cur2 = cur2.next;
                cur = cur.next;
            }
            if (cur1 != null) {
                cur.next = cur1;
                cur1 = cur1.next;
                cur = cur.next;
            }
        }
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{1, 2, 3, 4, 5});
        LinkedList.printLinkedList(head);
        reorderList(head);
        LinkedList.printLinkedList(head);
    }
}
