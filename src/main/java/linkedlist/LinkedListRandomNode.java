

package linkedlist;

import java.util.Random;

public class LinkedListRandomNode {

    /**
     * @param head The linked list's head.
     * Note that the head is guaranteed to be not null, so it contains at least one node.
     */

    ListNode head = null;
    Random randomGenerator = null;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        this.randomGenerator = new Random();

    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode result = null;
        ListNode current = head;

        for (int n = 1; current != null; n++) {
            if (randomGenerator.nextInt(n) == 0) {
                result = current;
            }
            current = current.next;
        }
        return result.val;
    }
}
