package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    // 判断两个Interval之间知否有交集
    public static boolean hasIntersection(Interval i1, Interval i2) {
        if (i1 == null || i1.end < i2.start) {
            return false;
        }
        return true;
    }

    // 合并两个Interval
    public static Interval mergeTwoIntervals(Interval i1, Interval i2) {
        int start = i1.start <= i2.start ? i1.start : i2.start;
        int end = i1.end >= i2.end ? i1.end : i2.end;
        return new Interval(start, end);
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> ret = new ArrayList<Interval>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for (int i = 0; i < intervals.size(); i++) {
            Interval oldInterval = ret.size() == 0 ? null : ret.get(ret.size() - 1);
            if (hasIntersection(oldInterval, intervals.get(i))) {
                Interval newInterval = mergeTwoIntervals(oldInterval, intervals.get(i));
                ret.remove(ret.size() - 1);
                ret.add(newInterval);
            } else {
                ret.add(intervals.get(i));
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<Interval>();
        list.add(new Interval(15, 18));
        list.add(new Interval(1, 3));
        list.add(new Interval(2, 6));
        list.add(new Interval(8, 10));
        System.out.println(merge(list));
    }
}
