package linkedlist;

public class LinkedList {

    public static ListNode constructLinkedList(int[]nums){
        ListNode dummy = new ListNode(-1);
        ListNode head  = dummy;

        for(int num : nums) {
            ListNode newNode = new ListNode(num);
            head.next = newNode;
            head = head.next;
        }
        return dummy.next;
    }

    public static void printLinkedList(ListNode header) {
        while(header != null) {
            System.out.print(header);
            header = header.next;
        }
        System.out.println();
    }
}
