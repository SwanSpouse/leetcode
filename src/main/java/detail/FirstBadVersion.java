package detail;

public class FirstBadVersion {

    /**
    * 二分查找的思想
    */
    public int firstBadVersion(int n) {
        int left  = 1;
        int right = n;
        int ret   = right;
        while(left <= right) {
            int mid = (right - left) / 2 + left;
            if (isBadVersion(mid)) {
                ret   = mid;
                right = mid - 1;
            } else {
                left  = mid + 1;
            }
        }
        return ret;
    }
}