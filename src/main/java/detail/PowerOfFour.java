package detail;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num == 0) {
            return false;
        }
        while (num % 4 == 0) {
            num = num >> 2;
        }
        return num == 1;
    }
}
