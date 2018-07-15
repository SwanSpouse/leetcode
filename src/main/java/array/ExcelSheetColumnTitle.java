package array;

public class ExcelSheetColumnTitle {

    public Character int2Char(int n) {
        return (char) ('A' + n - 1);
    }

    public String convertToTitle(int n) {
        String ret = "";
        while (n != 0) {
            if (n % 26 == 0) {
                ret = int2Char(26) + ret;
                n = n / 26 - 1;
            } else {
                ret = int2Char(n % 26) + ret;
                n = n / 26;
            }
        }
        return ret;
    }
}
