package linkedlist;

public class AddTwoNumbersII {

    public ListNode reverse(ListNode head) {
        ListNode dummy = new ListNode(-1);
        while (head != null) {
            ListNode cur = head;
            head = head.next;
            cur.next = dummy.next;
            dummy.next = cur;
        }
        return dummy.next;
    }

    public int getLength(ListNode head) {
        int count = 0;
        for (; head != null; head = head.next, count += 1) ;
        return count;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length1 = getLength(l1);
        int length2 = getLength(l2);

        ListNode temp;
        if (length1 < length2) {
            temp = l1;
            l1 = l2;
            l2 = temp;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(-1);

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        for (int i = 0; i < Math.abs(length1 - length2); i++, cur1 = cur1.next) {
            ListNode newNode = new ListNode(cur1.val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        for (; cur1 != null && cur2 != null; cur1 = cur1.next, cur2 = cur2.next) {
            ListNode newNode = new ListNode(cur1.val + cur2.val);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }

        int carry = 0;
        for (ListNode cur = dummy.next; cur != null; cur = cur.next) {
            int curValue = (cur.val + carry) % 10;
            carry = (cur.val + carry) / 10;
            cur.val = curValue;
        }

        dummy.next = reverse(dummy.next);
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = dummy.next;
            dummy.next = newNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = LinkedList.constructLinkedList(new int[]{9});
        ListNode l2 = LinkedList.constructLinkedList(new int[]{9, 9, 9});

        LinkedList.printLinkedList(new AddTwoNumbersII().addTwoNumbers(l1, l2));
    }
}
