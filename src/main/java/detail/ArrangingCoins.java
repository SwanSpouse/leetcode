package detail;

public class ArrangingCoins {
    public int arrangeCoins(int n) {
        int cur = 0;
        int count = 1;
        while (n > 0) {
            cur += 1;
            count += 1;
            n -= count;
        }
        return cur;
    }

    public static void main(String[] args) {
        System.out.println(new ArrangingCoins().arrangeCoins(5));
        System.out.println(new ArrangingCoins().arrangeCoins(8));
    }
}
