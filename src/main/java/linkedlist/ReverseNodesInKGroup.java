package linkedlist;

/**
 *   这里最重要的就是细心。其实有好多方法都可以解决这个问题。
 */
class ReverseNodesInKGroup {

    // reverse pre和tail 之间的节点
    public static ListNode reverse(ListNode pre, ListNode tail) {
        if (pre == null){
            return pre;
        }
        ListNode head = pre.next;
        pre.next = tail;
        while( head != tail){
            ListNode cur = head;
            head = head.next;
            cur.next = pre.next;
            pre.next = cur;
        }
        return pre;
    }

    public static ListNode moveNStep(ListNode head, int n) {
        for(int i=0; i <n-1; i ++ ) {
            head = head.next;
        }
        return head;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;

        while(cur != null) {
            ListNode pre = cur;
            for(int i=0; i < k && cur != null; i ++ ) {
                cur = cur.next;
            }
            if ( cur != null) {
                reverse(pre, cur.next);
                cur = moveNStep(cur, k);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        for(int i=1; i <= 5; i ++ ) {
            System.out.println("====================="+i+"======================");
            ListNode head = LinkedList.constructLinkedList(new int[]{1,2,3,4,5});
            LinkedList.printLinkedList(reverseKGroup(head, i));
        }
    }
}