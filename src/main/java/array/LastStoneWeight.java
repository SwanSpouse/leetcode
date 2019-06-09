package array;

import java.util.ArrayList;
import java.util.Collections;

public class LastStoneWeight {

    public int binarySearch(ArrayList<Integer> list, int val) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (list.get(mid) == val) {
                return mid;
            } else if (list.get(mid) > val) {
                right = mid - 1;
            } else if (list.get(mid) < val) {
                left = mid + 1;
            }
        }
        return left;
    }

    public void findAndInsert(ArrayList<Integer> stoneList, int stone) {
        stoneList.add(binarySearch(stoneList, stone), stone);
    }

    public int lastStoneWeight(int[] stones) {
        ArrayList<Integer> stoneList = new ArrayList<>();
        for (int i = 0; i < stones.length; i++) {
            stoneList.add(stones[i]);
        }
        Collections.sort(stoneList);

        while (stoneList.size() >= 2) {
            int first = stoneList.get(stoneList.size() - 1);
            stoneList.remove(stoneList.size() - 1);

            int second = stoneList.get(stoneList.size() - 1);
            stoneList.remove(stoneList.size() - 1);

            int newStone = first - second;
            if (newStone > 0) {
                findAndInsert(stoneList, newStone);
            }
        }
        return stoneList.size() == 1 ? stoneList.get(0) : 0;
    }

    public static void main(String[] args) {
//        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new LastStoneWeight().lastStoneWeight(new int[]{3, 7, 8}));
    }
}
