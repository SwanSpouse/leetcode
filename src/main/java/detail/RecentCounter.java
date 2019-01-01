package detail;

import java.util.Deque;
import java.util.LinkedList;

public class RecentCounter {

    Deque<Integer> deque;

    public RecentCounter() {
        deque = new LinkedList<>();
    }

    public int ping(int t) {
        deque.offerLast(t);
        while (!deque.isEmpty() && deque.getFirst() < (t - 3000)) deque.pollFirst();

        return deque.size();
    }
}
