package array;

public class OneBitAndTwoBitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (i == bits.length - 1 && bits[i] == 0) {
                return true;
            }
            if (bits[i] == 1) {
                i += 2;
            } else if (bits[i] == 0) {
                i += 1;
            }
        }
        return false;
    }
}
