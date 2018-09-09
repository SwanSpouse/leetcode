package sort_and_search;

public class FirstBadVersion {

    public boolean isBadVersion(int n) {
        return n >= 1;
    }

    public int firstBadVersion(int n) {
        int left = 1, right = n;
        int ret = left;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                ret = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
                ret = left;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new FirstBadVersion().firstBadVersion(3));
    }
}
