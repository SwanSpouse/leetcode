package array;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int cur = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) {
                continue;
            }
            int left = i == 0 ? 0 : flowerbed[i - 1];
            int right = i == flowerbed.length - 1 ? 0 : flowerbed[i + 1];
            if (left == 0 && right == 0) {
                cur += 1;
                flowerbed[i] = 1;
            }
            if (cur >= n) {
                return true;
            }
        }
        return cur >= n;
    }
}
