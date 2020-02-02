package detail;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<Integer>();

        int[] left = new int[26], right = new int[26];
        for (int i = 0; i < left.length; i++) {
            left[i] = Integer.MAX_VALUE;
            right[i] = Integer.MIN_VALUE;
        }

        HashMap<Character, Integer> count = new HashMap<>();
        String order = "";
        for (int i = 0; i < S.length(); i++) {
            int index = S.charAt(i) - 'a';
            left[index] = Math.min(left[index], i);
            right[index] = Math.max(right[index], i);
            if (!count.containsKey(S.charAt(i))) {
                count.put(S.charAt(i), 1);
                order += S.charAt(i);
            } else {
                count.put(S.charAt(i), count.get(S.charAt(i)) + 1);
            }
        }

        int index = 0;
        while (index < order.length()) {
            int total = 0, cur = 0, leftIndex = Integer.MAX_VALUE, rightIndex = Integer.MIN_VALUE;
            HashSet<Character> set = new HashSet<>();
            do {
                int pos = order.charAt(index) - 'a';

                leftIndex = Math.min(leftIndex, left[pos]);
                rightIndex = Math.max(rightIndex, right[pos]);

                total = rightIndex - leftIndex + 1;

                if (!set.contains(order.charAt(index))) {
                    cur += count.get(order.charAt(index));
                }
                set.add(order.charAt(index));

                index += 1;
            } while (cur < total);
            ret.add(cur);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }
}