package linkedlist;

public class FlattenAMultilevelDoublyLinkedList {
    class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;

        public Node() {
        }

        public Node(int _val, Node _prev, Node _next, Node _child) {
            val = _val;
            prev = _prev;
            next = _next;
            child = _child;
        }
    }

    public Node construct(Node head, Node next) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            Node curNext = cur.next;
            if (cur.child != null) {
                Node newNode = construct(cur.child, curNext);
                cur.child = null;
                cur.next = newNode;
                newNode.prev = cur;
            }
            if (curNext == null) {
                break;
            }
            cur = curNext;
        }
        if (next != null) {
            cur.next = next;
            next.prev = cur;
        }
        return head;
    }

    public Node flatten(Node head) {
        return construct(head, null);
    }
}
