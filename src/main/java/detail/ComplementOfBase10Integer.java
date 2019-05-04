package detail;

public class ComplementOfBase10Integer {

    private String intToBinary(int input) {
        if (input == 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        while (input != 0) {
            sb.insert(0, input % 2);
            input = input / 2;
        }
        return sb.toString();
    }

    private int binaryToInt(String input) {
        int bit = 1;
        int ret = 0;
        for (int i = input.length() - 1; i >= 0; i--) {
            ret = ret + bit * (input.charAt(i) - '0');
            bit *= 2;
        }
        return ret;
    }

    public int bitwiseComplement(int N) {
        StringBuffer sbN = new StringBuffer(intToBinary(N));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < sbN.length(); i++) {
            if (sbN.charAt(i) == '0') {
                sb.append('1');
            } else {
                sb.append('0');
            }
        }
        return binaryToInt(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new ComplementOfBase10Integer().bitwiseComplement(10));
    }
}
