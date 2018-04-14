package detail;

public class NumberComplement {

    /*
    简单题，求补码
     */
    public String numToBinary(int num) {
        String ret = "";
        while (num != 0) {
            ret = num % 2 + ret;
            num = num / 2;
        }
        return ret;
    }

    public int findComplement(int num) {
        String binary = numToBinary(num);
        int ret = 0;
        int bit = 1;
        for (int i = binary.length() - 1; i >= 0; i--, bit *= 2) {
            if (binary.charAt(i) == '0') {
                ret = ret + bit;
            }
        }
        return ret;
    }
}
