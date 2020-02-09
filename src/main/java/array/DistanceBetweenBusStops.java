package array;

public class DistanceBetweenBusStops {
    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        int clockwise = 0;
        for (int i = start; i != destination; i = (i + 1) % distance.length) {
            clockwise += distance[i];
        }
        int counterclockwise = 0;
        for (int i = start; i != destination; ) {
            int pos = i - 1 >= 0 ? i - 1 : i - 1 + distance.length;
            counterclockwise += distance[pos];
            i = pos;
        }
        return Math.min(clockwise, counterclockwise);
    }
}
