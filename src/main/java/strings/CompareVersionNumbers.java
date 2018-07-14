package strings;

public class CompareVersionNumbers {

    public static int compareVersion(String version1, String version2) {
        String[] fields1 = version1.split("\\.");
        String[] fields2 = version2.split("\\.");

        for (int i = 0; i < fields1.length || i < fields2.length; i++) {
            int val1 = i < fields1.length ? Integer.parseInt(fields1[i]) : 0;
            int val2 = i < fields2.length ? Integer.parseInt(fields2[i]) : 0;
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("0.1", "1.1"));
        System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("7.5.2.4", "7.5.2.3"));
    }
}
