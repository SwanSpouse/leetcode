package detail;

import java.util.*;

public class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> map;
    Random rand = new Random();

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        list = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int pos = map.get(val);
        if (pos < list.size() - 1) { // not the last one than swap the last one with this val
            int lastOne = list.get(list.size() - 1);
            list.set(pos, lastOne);
            map.put(lastOne, pos);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

//    public void show() {
//        System.out.println("=============");
//        for (int key : map.keySet()) {
//            System.out.println(key + ":" + map.get(key));
//        }
//        Print.printList(this.list);
//    }

    public static void main(String[] args) {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);
        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());
        System.out.println(rs.getRandom());
    }
}
