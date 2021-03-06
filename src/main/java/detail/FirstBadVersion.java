package detail;

public class FirstBadVersion {

    // LeetCode系统给出的方法名，并没有给出实现细节。
    public boolean isBadVersion(int input) {
        return true;
    }

    /**
     * 二分查找的思想
     */
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        int ret = right;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                ret = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ret;
    }
}