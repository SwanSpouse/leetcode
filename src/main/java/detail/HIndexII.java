package detail;

// 到SCI网站，查出某个人发表的所有SCI论文，让其按被引次数从高到低排列，往下核对，直到某篇论文的序号大于该论文被引次数，那个序号减去1就是h指数。
public class HIndexII {
    public int hIndex(int[] citations) {
        int len = citations.length;

        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= len - mid) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }

    public static void main(String[] args) {
        System.out.println(new HIndexII().hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(new HIndexII().hIndex(new int[]{0, 1}));
        System.out.println(new HIndexII().hIndex(new int[]{1}));
    }
}
