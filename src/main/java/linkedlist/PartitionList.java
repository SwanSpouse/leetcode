package linkedlist;

/**
 *  思路是创建一个新的list来存放不小于的元素。而不能把不小于x的放到尾巴。这样就循环了。不能找到尾指针。
 */
public class PartitionList {
	public static ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode newDummy = new ListNode(-1);
        ListNode cur = newDummy;

        ListNode pre = dummy;
        while(pre.next != null) {
        	if(pre.next.val >= x ) {
        		cur.next = pre.next;
        		cur = cur.next;
        		pre.next = pre.next.next;
        	} else {
        		pre = pre.next;
        	}
        }
        cur.next = null;
        pre.next = newDummy.next;
        return dummy.next;
    }
}