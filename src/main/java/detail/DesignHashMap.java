package detail;

public class DesignHashMap {

    private int[] array;

    /** Initialize your data structure here. */
    public DesignHashMap() {
        array = new int[1000001];
        for(int i=0; i < array.length; i ++) {
            array[i] = -1;
        }
    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        this.array[key] = value;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        return this.array[key];
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        this.array[key] = -1;
    }
}
