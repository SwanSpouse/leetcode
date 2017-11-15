package linkedlist;

/**
 * 印象挺深的，所以记得很清楚。
 */

public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode newHeader = dummy;
        int bit = 0;
        while (l1 != null || l2 != null || bit != 0){
            int value1 = l1 == null ? 0 : l1.val;
            int value2 = l2 == null ? 0 : l2.val;
            newHeader.next = new ListNode((value1 + value2 + bit) % 10);
            bit = (value1 + value2 + bit) / 10;
            newHeader = newHeader.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedList.constructLinkedList(new int[]{2, 4, 5});
        ListNode l2 = LinkedList.constructLinkedList(new int[]{5, 6, 4});

        LinkedList.printLinkedList(l1);
        LinkedList.printLinkedList(l2);

        LinkedList.printLinkedList(addTwoNumbers(l1, l2));
    }
}


