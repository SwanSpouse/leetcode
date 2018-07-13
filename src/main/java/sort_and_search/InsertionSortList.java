package sort_and_search;

import linkedlist.LinkedList;
import linkedlist.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode preCur = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode preNode = dummy;
            ListNode node = dummy.next;
            while (node.val < cur.val && node != cur) {
                preNode = preNode.next;
                node = node.next;
            }
            if (node != cur) {
                ListNode next = cur.next;
                preCur.next = cur.next;
                cur.next = preNode.next;
                preNode.next = cur;
                cur = next;
            } else {
                preCur = preCur.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{4, 2, 1, 3});
        ListNode newHead = new InsertionSortList().insertionSortList(head);
        LinkedList.printLinkedList(newHead);

        head = LinkedList.constructLinkedList(new int[]{-1, 5, 3, 4, 0});
        newHead = new InsertionSortList().insertionSortList(head);
        LinkedList.printLinkedList(newHead);

    }
}
