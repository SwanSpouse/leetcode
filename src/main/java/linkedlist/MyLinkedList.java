package linkedlist;

public class MyLinkedList {

    private class SinglyListNode {
        int val;
        SinglyListNode next;

        SinglyListNode(int x) {
            val = x;
        }
    }

    private SinglyListNode head;
    //abstraction function: head represents the head of the LinkedList, if head.val = -1, represents an empty LinkedList

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (head == null) return -1;

        SinglyListNode cur = head;

        for (int i = 0; i <= index; i++) {
            if (index == i && cur != null)
                return cur.val;
            else if (index == i && cur == null)
                return -1;
            if (cur != null)
                cur = cur.next;
        }

        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the
     * new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        SinglyListNode insert = new SinglyListNode(val);

        insert.next = head;
        head = insert;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        SinglyListNode insert = head;
        SinglyListNode end = new SinglyListNode(val);

        //do not use null...only for submission
        while (insert.next != null) {
            insert = insert.next;
        }

        insert.next = end;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to
     * the length of linked list, the node will be appended to the end of linked list.
     * If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        SinglyListNode insert = new SinglyListNode(val);
        SinglyListNode cur = head;
        int curPointer = 0;

        if (cur == null && index == 0) {
            this.addAtHead(val);
        } else if (cur == null && index > 0) {
            return;
        }

        if (cur != null && cur.next != null) {
            SinglyListNode prev = cur;
            for (int i = 0; i < index; i++) {
                prev = cur;
                cur = cur.next;
                curPointer += 1;
            }
            insert.next = cur;
            prev.next = insert;
        } else if (curPointer + 1 == index) {
            this.addAtTail(val);
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        SinglyListNode cur = head;
        int curPointer = 0;

        if (cur == null) {
            return;
        }
        if (cur.next == null && index == 0) head = null;
        else {
            SinglyListNode prev = cur;
            while (cur.next != null) {
                prev = cur;
                cur = cur.next;
                curPointer++;
                if (curPointer == index) {
                    prev.next = cur.next;
                    break;
                }
            }
        }
    }
}
