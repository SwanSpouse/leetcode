package linkedlist;

/**
 *  链表细节题。为了简化情况，引入了一个boolean变量。
 */
public class RemoveDuplicatesFromSortedListII {

	public static ListNode deleteDuplicates(ListNode head) {
     	ListNode dummy = new ListNode(-1);
     	dummy.next = head;
     	ListNode pre = dummy;

     	while(pre.next != null) {
     		ListNode cur = pre.next;
     		boolean hasSame = false;
     		while(cur != null && cur.next != null && cur.val == cur.next.val) {
     			cur = cur.next;
     			hasSame = true;
     		}
     		pre.next = hasSame ? cur.next : cur;
     		pre = hasSame ? pre : cur;
     	}
     	return dummy.next;
    }
}