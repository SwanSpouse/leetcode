package detail;

import java.util.ArrayList;
import java.util.List;

public class RecentCounter {

    List<Integer> pings;

    private int binarySearch(int value) {
        int left = 0;
        int right = pings.size() - 1;
        int ret = -1;
        while (left <= right) {
            int min = (right - left) / 2 + left;
            if (pings.get(min) < value) {
                left = min + 1;
            } else if (pings.get(min) >= value) {
                if (pings.get(min) == value) {
                    ret = min;
                }
                right = min - 1;
            }
        }
        return ret != -1 ? ret : left;
    }

    public RecentCounter() {
        pings = new ArrayList<>();
    }

    public int ping(int t) {
        pings.add(t);
        int left = binarySearch(t - 3000);
        if (pings.get(left) < t - 3000) {
            left += 1;
        }
        pings = pings.subList(left, pings.size());
        return pings.size();
    }
}
