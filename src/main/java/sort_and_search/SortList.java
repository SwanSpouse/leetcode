package sort_and_search;

import linkedlist.LinkedList;
import linkedlist.ListNode;

/*
归并排序思想
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = slow.next;
        slow.next = null;

        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);

        ListNode cur1 = firstHalf;
        ListNode cur2 = secondHalf;
        ListNode cur = dummy;

        while (cur1 != null || cur2 != null) {
            if (cur1 == null) {
                cur.next = cur2;
                break;
            } else if (cur2 == null) {
                cur.next = cur1;
                break;
            } else if (cur1.val < cur2.val) {
                cur.next = cur1;
                cur = cur.next;
                cur1 = cur1.next;
            } else {
                cur.next = cur2;
                cur = cur.next;
                cur2 = cur2.next;
            }
        }
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{4, 2, 1, 3});
        ListNode newHead = new SortList().sortList(head);
        LinkedList.printLinkedList(newHead);

        head = LinkedList.constructLinkedList(new int[]{4, 1, 2, 5, 3, 6, 9});
        newHead = new SortList().sortList(head);
        LinkedList.printLinkedList(newHead);
    }
}
