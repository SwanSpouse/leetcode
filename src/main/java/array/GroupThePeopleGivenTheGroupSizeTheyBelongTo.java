package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupThePeopleGivenTheGroupSizeTheyBelongTo {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> sizeMap = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!sizeMap.containsKey(groupSizes[i])) {
                sizeMap.put(groupSizes[i], new ArrayList<>());
            }
            sizeMap.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> ret = new ArrayList<>();
        for (Integer groupSize : sizeMap.keySet()) {
            for (int i = 0; i < sizeMap.get(groupSize).size(); ) {
                ArrayList<Integer> cur = new ArrayList<>();
                for (int count = 0; count < groupSize; count++, i++) {
                    cur.add(sizeMap.get(groupSize).get(i));
                }
                ret.add(cur);
            }
        }
        return ret;
    }
}
