
package tree;

/*
左子树的最后一个元素的处理引入了Dummy。
这个应该有更简单的方法。
 */
public class ConvertSortedListToBinarySearchTree {

	public TreeNode generate(ListNode head) {
		if(head ==null) {
			return null;
		}
		if (head.next == null) {
			return new TreeNode(head.val);
		}
		ListNode dummy = new ListNode(-1);
		dummy.next = head;

		ListNode faster    = head;
		ListNode slower    = head;
		ListNode preSlower = dummy;
		while( faster != null && faster.next != null ) {
			faster = faster.next.next;
			slower = slower.next;
			preSlower = preSlower.next;
		}
		TreeNode node = new TreeNode(slower.val);
		ListNode rightHeader = slower.next;
		slower.next = null;
		preSlower.next = null;

		node.left  = generate(head);
		node.right = generate(rightHeader);
		return node;
	}

	public TreeNode sortedListToBST(ListNode head) {
		return generate(head);
	}
}
