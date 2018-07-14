package array;

public class ExcelSheetColumnTitle {

    public static Character int2Char(int n) {
        return (char) ('A' + n - 1);
    }

    public static String convertToTitle(int n) {
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

    public static void main(String[] args) {
        System.out.println(convertToTitle(1));
        System.out.println(convertToTitle(701));
        System.out.println(convertToTitle(729));
        System.out.println(convertToTitle(28));
        System.out.println(convertToTitle(52));
        System.out.println(convertToTitle(26));
    }
}
