package linkedlist;

class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode nextNode = curNode.next;
        while(nextNode != null) {
            if(curNode.val != nextNode.val) {
                curNode.next = nextNode;
                curNode = curNode.next;
            }
            nextNode = nextNode.next;
        }
        curNode.next = null;
        return head;
    }
}