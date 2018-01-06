package linkedlist;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.length - 1);
    }

    /**
     * 这个做法很精彩。假定这些数据长度都差不多。然后两两merge
     * TODO lmj 写文章
     */
    public static ListNode mergeHelper(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        if(start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode res = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                dummy.next = l1;
                l1 = l1.next;
                dummy = dummy.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
                dummy = dummy.next;
            }
        }
        if(l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedList.constructLinkedList(new int[]{1, 4, 7});
        ListNode head2 = LinkedList.constructLinkedList(new int[]{3, 6, 9});
        ListNode head3 = LinkedList.constructLinkedList(new int[]{2, 5, 8});
        ListNode head4 = LinkedList.constructLinkedList(new int[]{2, 5, 8});
        LinkedList.printLinkedList(mergeKLists(new ListNode[]{head1, head2, head3, head4}));
    }

}
