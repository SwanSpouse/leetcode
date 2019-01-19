package detail;

public class ReachANumber {

    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    public static void main(String[] args) {
        System.out.println(new ReachANumber().reachNumber(3));
        System.out.println(new ReachANumber().reachNumber(2));
    }
}
