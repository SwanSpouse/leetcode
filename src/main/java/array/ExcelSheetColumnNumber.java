package array;

public class ExcelSheetColumnNumber {

    public int char2Int(char c) {
        return c - 'A' + 1;
    }

    public int titleToNumber(String s) {
        int ret = 0;
        for (int i = 0; i < s.length(); i++) {
            ret = 26 * ret + char2Int(s.charAt(i));
        }
        return ret;
    }

    public static void main(String[] args) {
        ExcelSheetColumnTitle source = new ExcelSheetColumnTitle();
        ExcelSheetColumnNumber target = new ExcelSheetColumnNumber();

        for (int i = 1; i < 1000; i++) {
            String title = source.convertToTitle(i);
            int number = target.titleToNumber(title);
            if (i != number) {
                System.out.println("fail:" + i + "," + title + "=>" + number);
            }
        }
        System.out.println("DONE");
    }
}
