package sort_and_search;

import linkedlist.LinkedList;
import linkedlist.ListNode;

public class InsertionSortList {

    public ListNode findAndInsert(ListNode head, ListNode preNode, ListNode node) {
        System.out.println("preNode:" + preNode.val + " node:" + node);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null && cur != node) {
            if (node.val < cur.val) {
                preNode.next = node.next;
                node.next = pre.next;
                pre.next = node;
                break;
            }
            cur = cur.next;
            pre = pre.next;
        }
        LinkedList.printLinkedList(dummy.next);
        return dummy.next;
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            ListNode preNext = pre.next;
            ListNode next = cur.next;
            dummy.next = findAndInsert(dummy.next, pre, cur);
            cur = next;
            pre = preNext;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{4, 2, 1, 3});
        ListNode newHead = new InsertionSortList().insertionSortList(head);
//        LinkedList.printLinkedList(newHead);
    }
}
