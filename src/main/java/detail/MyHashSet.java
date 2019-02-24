package detail;

public class MyHashSet {

    boolean[] set;

    /**
     * Initialize your data structure here.
     */
    public MyHashSet() {
        set = new boolean[1000000];
    }

    public void add(int key) {
        set[key] = true;
    }

    public void remove(int key) {
        set[key] = false;
    }

    /**
     * Returns true if this set contains the specified element
     */
    public boolean contains(int key) {
        return set[key];
    }
}
