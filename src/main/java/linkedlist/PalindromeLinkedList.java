package linkedlist;

public class PalindromeLinkedList {

    public ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);

        while (head != null) {
            ListNode next = dummy.next;
            ListNode newHead = head.next;
            dummy.next = head;
            head.next = next;
            head = newHead;
        }
        return dummy.next;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int length = 0;
        for (ListNode node = head; node != null; node = node.next, length += 1) ;

        int mid = length % 2 == 1 ? (length + 1) / 2 : length / 2;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode midNode = head;
        ListNode pre = dummy;
        for (int i = 0; i < mid; i++) {
            midNode = midNode.next;
            pre = pre.next;
        }

        pre.next = null;
        midNode = reverseList(midNode);

        while (head != null && midNode != null) {
            if (head.val != midNode.val) {
                return false;
            }
            head = head.next;
            midNode = midNode.next;
        }
        return true;
    }

    public static void main(String[] args) {
//        LinkedList.printLinkedList(new PalindromeLinkedList().reverseList(LinkedList.constructLinkedList(new int[]{1, 2, 3, 4, 5})));
        System.out.println(new PalindromeLinkedList().isPalindrome(LinkedList.constructLinkedList(new int[]{1, 2, 3, 2, 1})));
        System.out.println(new PalindromeLinkedList().isPalindrome(LinkedList.constructLinkedList(new int[]{1, 2, 2, 1})));
        System.out.println(new PalindromeLinkedList().isPalindrome(LinkedList.constructLinkedList(new int[]{1, 2, 2, 1, 2})));
    }
}
