package array;

import java.util.HashSet;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> kinds = new HashSet<>();
        for (int i = 0; i < candies.length; i++) {
            kinds.add(candies[i]);
        }
        int half = candies.length / 2;
        return kinds.size() >= half ? half : kinds.size();
    }

    public static void main(String[] args) {
        System.out.println(new DistributeCandies().distributeCandies(new int[]{1, 1, 2, 2, 3, 3}));
        System.out.println(new DistributeCandies().distributeCandies(new int[]{1, 1, 2, 3}));
    }
}
