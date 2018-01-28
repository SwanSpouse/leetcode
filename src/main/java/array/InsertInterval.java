package array;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            ret.add(newInterval);
            return ret;
        }
        boolean hasAdd = false;
        for (int i = 0; i < intervals.size(); i++) {
            if (intervals.get(i).end < newInterval.start) {
                ret.add(intervals.get(i));
                if (i == intervals.size() - 1 && !hasAdd) {
                    ret.add(newInterval);
                    hasAdd = true;
                }
            } else if (newInterval.end < intervals.get(i).start) {
                if (!hasAdd) {
                    ret.add(newInterval);
                    hasAdd = true;
                }
                ret.add(intervals.get(i));
            } else {
                newInterval.start = newInterval.start < intervals.get(i).start ? newInterval.start : intervals.get(i).start;
                newInterval.end = newInterval.end < intervals.get(i).end ? intervals.get(i).end : newInterval.end;
                if (i == intervals.size() - 1 && !hasAdd) {
                    ret.add(newInterval);
                    hasAdd = true;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        ArrayList<Interval> list = new ArrayList<Interval>();
//        list.add(new Interval(1, 2));
//        list.add(new Interval(3, 5));
//        list.add(new Interval(6, 7));
//        list.add(new Interval(8, 10));
//        list.add(new Interval(12, 16));
//        System.out.println(insert(list, new Interval(4, 9)));
        list.add(new Interval(2, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 9));
        System.out.println(insert(list, new Interval(0, 1)));
    }
}
