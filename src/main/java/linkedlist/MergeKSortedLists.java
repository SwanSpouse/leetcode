package linkedlist;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        ListNode newListTail = dummy;

        boolean isAllNull = false;
        while (!isAllNull) {
            isAllNull = true;
            int minValPos = -1;
            int minVal = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                int val = lists[i] == null ? Integer.MAX_VALUE : lists[i].val;
                if (minVal > val) {
                    minValPos = i;
                    minVal = lists[i].val;
                    isAllNull = false;
                }
            }
            if (!isAllNull) {
                newListTail.next = lists[minValPos];
                newListTail = newListTail.next;
                lists[minValPos] = lists[minValPos].next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head1 = LinkedList.constructLinkedList(new int[]{1, 4, 7});
        ListNode head2 = LinkedList.constructLinkedList(new int[]{3, 6, 9});
        ListNode head3 = LinkedList.constructLinkedList(new int[]{2, 5, 8});
        ListNode head4 = LinkedList.constructLinkedList(new int[]{2, 5, 8});
        LinkedList.printLinkedList(mergeKLists(new ListNode[]{head1, head2, head3, head4}));
    }

}
