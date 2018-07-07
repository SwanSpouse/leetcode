package linkedlist;

public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
			if (fast == slow && fast != null) {
				return true;
			}
		}
		return false;
    }
}
