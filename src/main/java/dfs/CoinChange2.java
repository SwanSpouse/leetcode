package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class CoinChange2 {

    HashSet<ArrayList<Integer>> set = new HashSet<>();

    public void dfs(int target, int[] coins, int cur, ArrayList<Integer> list) {
        if (target == 0) {
            set.add(new ArrayList<>(list));
            return;
        }
        for (int i = cur; i < coins.length; i++) {
            if (target < coins[i]) {
                return;
            }
            list.add(coins[i]);
            dfs(target - coins[i], coins, i, list);
            list.remove(list.size() - 1);
        }
    }

    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        dfs(amount, coins, 0, new ArrayList<>());
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new CoinChange2().change(5, new int[]{1, 2, 5}));
        System.out.println(new CoinChange2().change(3, new int[]{2}));
    }
}
