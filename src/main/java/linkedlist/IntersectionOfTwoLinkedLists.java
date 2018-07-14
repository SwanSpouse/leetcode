package linkedlist;

public class IntersectionOfTwoLinkedLists {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int lA = 0;
        int lB = 0;

        while (curA.next != null || curB.next != null) {
            if (curA.next != null) {
                curA = curA.next;
                lA += 1;
            }
            if (curB.next != null) {
                lB += 1;
                curB = curB.next;
            }
        }
        // 如果两个链表没有重合点，返回null
        if (curA != curB) {
            return null;
        }
        // 如果有重合，让长链表先走差值的步长
        ListNode longHead = lA >= lB ? headA : headB;
        ListNode shortHead = lA >= lB ? headB : headA;

        for (int i = 0; i < Math.abs(lA - lB); i++) {
            longHead = longHead.next;
        }
        while (longHead != shortHead) {
            longHead = longHead.next;
            shortHead = shortHead.next;
        }
        return longHead;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l21 = new ListNode(6);
        ListNode l22 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l21.next = l22;
        l22.next = l3;
        System.out.println(getIntersectionNode(l1, l21));
    }
}
