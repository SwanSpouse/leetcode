package detail;

public class ConvertANumberToHexadecimal {
    public String toHex(int num) {
        char[] map = {'a', 'b', 'c', 'd', 'e', 'f'}; // map[i - 10]
        if (num == 0) return "0";
        String res = "";
        while (num != 0) {
            int v = num & 0b1111;
            if (v >= 10) res = map[v - 10] + res;
            else res = v + res;
            num >>>= 4;
        }
        return res;
    }
}
