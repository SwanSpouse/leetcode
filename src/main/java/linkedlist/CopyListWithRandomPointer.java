package linkedlist;

public class CopyListWithRandomPointer {

    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        // 1. dup old list
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode newNode = new RandomListNode(cur.label);
            newNode.next = cur.next;
            cur.next = newNode;
            cur = cur.next.next;
        }
        // 2. copy random pointer
        cur = head;
        while (cur != null) {
            RandomListNode newNode = cur.next;
            newNode.random = cur.random == null ? null : cur.random.next;
            cur = cur.next.next;
        }
        // 3. split two list
        RandomListNode newHead = head.next;
        RandomListNode newNode = head.next;
        cur = head;
        while (cur != null) {
            cur.next = cur.next == null ? null : cur.next.next;
            newNode.next = newNode.next == null ? null : newNode.next.next;

            cur = cur.next;
            newNode = newNode.next;
        }
        return newHead;
    }
}
