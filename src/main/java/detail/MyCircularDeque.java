package detail;

public class MyCircularDeque {

    private int[] queue;
    private int length;
    private int left, right;

    private int reIndex(int pos) {
        if (pos < 0) {
            return pos + queue.length;
        } else if (pos >= queue.length) {
            return pos % queue.length;
        }
        return pos;
    }

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.queue = new int[k];
        this.length = 0;
        this.left = -1;
        this.right = -1;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {
        if (this.length == queue.length) {
            return false;
        }
        if (this.left == -1) {
            this.left = 0;
            this.right = 1;
        }
        this.queue[this.left] = value;
        this.left = reIndex(this.left - 1);
        this.length += 1;
        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.length == queue.length) {
            return false;
        }
        if (this.right == -1) {
            this.right = 0;
            this.left = queue.length - 1;
        }
        this.queue[this.right] = value;
        this.right = reIndex(this.right + 1);
        this.length += 1;
        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.length == 0) {
            return false;
        }
        this.left = reIndex(this.left + 1);
        this.length -= 1;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {
        if (this.length == 0) {
            return false;
        }
        this.right = reIndex(this.right - 1);
        this.length -= 1;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (this.length == 0) {
            return -1;
        }
        return queue[reIndex(this.left + 1)];
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (this.length == 0) {
            return -1;
        }
        return queue[reIndex(this.right - 1)];
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return this.length == queue.length;
    }
}
