package sort_and_search;

import java.util.*;

public class TopKFrequentElements {

    public static class Pair {
        Integer k;
        Integer v;

        public Pair(int k, int v) {
            this.k = k;
            this.v = v;
        }

        public void Add() {
            this.v += 1;
        }

        @Override
        public int hashCode() {
            return k.hashCode();
        }

        @Override
        public String toString() {
            return k + ":" + v;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).Add();
            } else {
                map.put(nums[i], new Pair(nums[i], 1));
            }
        }
        List<Pair> temp = new ArrayList<Pair>();
        for (Integer key : map.keySet()) {
            temp.add(map.get(key));
        }

        Collections.sort(temp, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.v - o1.v;
            }
        });
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < k && i < temp.size(); i++) {
            ret.add(temp.get(i).k);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new TopKFrequentElements().topKFrequent(new int[]{1, 1, 1, 2, 2, 3, 4}, 2));
        System.out.println(new TopKFrequentElements().topKFrequent(new int[]{1}, 1));
        System.out.println(new TopKFrequentElements().topKFrequent(new int[]{3, 0, 1, 0}, 1));
    }
}
