package linkedlist;

public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if(head == null) {
            return null;
        }
        // even list
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        // odd list
        ListNode pre = head;
        ListNode node = head.next;

        while(node != null) {
            cur.next = node;
            cur = cur.next;

            pre.next = node.next;
            pre = pre.next == null ? pre : pre.next;
            node = pre == null ? null : pre.next;
        }
        cur.next = null;
        pre.next = dummy.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = LinkedList.constructLinkedList(new int[]{1,2,3,4,5});
        LinkedList.printLinkedList(new OddEvenLinkedList().oddEvenList(head));

        head = LinkedList.constructLinkedList(new int[]{1});
        LinkedList.printLinkedList(new OddEvenLinkedList().oddEvenList(head));

        head = LinkedList.constructLinkedList(new int[]{1,2});
        LinkedList.printLinkedList(new OddEvenLinkedList().oddEvenList(head));

        head = LinkedList.constructLinkedList(new int[]{1,2, 3});
        LinkedList.printLinkedList(new OddEvenLinkedList().oddEvenList(head));
    }
}
