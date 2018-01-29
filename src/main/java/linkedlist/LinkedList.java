package linkedlist;

public class LinkedList {

    public static ListNode constructLinkedList(int[] nums) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        for (int num : nums) {
            ListNode newNode = new ListNode(num);
            head.next = newNode;
            head = head.next;
        }
        return dummy.next;
    }

    private static final int warningLimit = 15;

    public static void printLinkedList(ListNode header) {
        if (header == null) {
            System.out.println("[NULL]");
        }
        int count = 0;
        while (header != null && count < warningLimit) {
            System.out.print(header);
            header = header.next;
            count += 1;
        }
        if (count >= warningLimit) {
            System.out.println("\n【严重告警】遍历链表的过程中出现死循环");
        }
        System.out.println();
    }
}
