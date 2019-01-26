package array;

import java.util.ArrayList;
import java.util.HashMap;

public class DegreeOfAnArray {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> itemPositions = new HashMap<>();
        int maxCount = 1;
        for (int i = 0; i < nums.length; i++) {
            if (itemPositions.containsKey(nums[i])) {
                itemPositions.get(nums[i]).add(i);
                maxCount = Math.max(maxCount, itemPositions.get(nums[i]).size());
            } else {
                ArrayList<Integer> position = new ArrayList<>();
                position.add(i);
                itemPositions.put(nums[i], position);
            }
        }

        int minLength = nums.length;
        for (Integer k : itemPositions.keySet()) {
            if (itemPositions.get(k).size() == maxCount) {
                ArrayList<Integer> pos = itemPositions.get(k);
                minLength = Math.min(minLength, pos.get(pos.size() - 1) - pos.get(0) + 1);
            }
        }
        return minLength;
    }

    public static void main(String[] args) {
        System.out.println(new DegreeOfAnArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(new DegreeOfAnArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
        System.out.println(new DegreeOfAnArray().findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2, 1}));
    }
}
