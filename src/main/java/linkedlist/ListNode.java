package linkedlist;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        this.val  = x;
        this.next = null;
    }

    @Override
    public String toString() {
        return this.val+"==>";
    }
}
