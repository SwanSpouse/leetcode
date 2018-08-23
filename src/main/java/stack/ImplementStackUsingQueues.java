package stack;

import java.util.LinkedList;

public class ImplementStackUsingQueues {
    Boolean isQ1InUser;
    LinkedList<Integer> q1;
    LinkedList<Integer> q2;

    /**
     * Initialize your data structure here.
     */
    public ImplementStackUsingQueues() {
        isQ1InUser = true;
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (isQ1InUser) {
            q1.addLast(x);
        } else {
            q2.addLast(x);
        }
    }

    public int top() {
        if (isQ1InUser) {
            int v = 0;
            while (!q1.isEmpty()) {
                v = q1.getFirst();
                q1.removeFirst();
                q2.addLast(v);
            }
            isQ1InUser = !isQ1InUser;
            return v;
        } else {
            int v = 0;
            while (!q2.isEmpty()) {
                v = q2.getFirst();
                q2.removeFirst();
                q1.addLast(v);
            }
            isQ1InUser = !isQ1InUser;
            return v;
        }
    }

    public int pop() {
        if (isQ1InUser) {
            int v = 0;
            while (!q1.isEmpty()) {
                v = q1.getFirst();
                if(q1.size() > 1) {
                    q2.addLast(v);
                }
                q1.removeFirst();
            }
            isQ1InUser = !isQ1InUser;
            return v;
        } else {
            int v = 0;
            while (!q2.isEmpty()) {
                v = q2.getFirst();
                if(q2.size() > 1) {
                    q1.addLast(v);
                }
                q2.removeFirst();
            }
            isQ1InUser = !isQ1InUser;
            return v;
        }
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
