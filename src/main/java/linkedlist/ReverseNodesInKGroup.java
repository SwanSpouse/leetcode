package linkedlist;

class ReverseNodesInKGroup {

	public static ListNode reverse(ListNode pre, ListNode tail) {
		if (pre == NULL || pre.next == NULL) {
			return pre;
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = pre.next;

		

		return dummy.next;
	}

    public static ListNode reverseKGroup(ListNode head, int k) {
        
    }	
}