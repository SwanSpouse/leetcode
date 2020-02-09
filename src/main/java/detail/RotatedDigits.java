package detail;

public class RotatedDigits {
    Character[] dict = new Character[]{'0', '1', '5', '-', '-', '2', '9', '-', '8', '6'};

    public int rotate(int n) {
        String rotated = "", input = n + "";
        for (int i = 0; i < input.length(); i++) {
            if (dict[input.charAt(i) - '0'] == '-') {
                return -1;
            } else {
                rotated += dict[input.charAt(i) - '0'];
            }
        }
        return Integer.parseInt(rotated);
    }

    public int rotatedDigits(int N) {
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            int cur = rotate(i);
            if (cur != -1 && i != cur) {
                ret += 1;
            }
        }
        return ret;
    }
}
