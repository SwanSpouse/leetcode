package linkedlist;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;

        while (l1 != null || l2 != null) {
            int cur1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int cur2 = l2 == null ? Integer.MAX_VALUE : l2.val;

            if (cur1 <= cur2) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }
}
