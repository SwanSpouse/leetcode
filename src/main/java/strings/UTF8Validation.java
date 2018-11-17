package strings;

public class UTF8Validation {

    public String int2binary(int input) {
        String ret = "";
        while (input != 0) {
            ret = input % 2 + ret;
            input = input / 2;
        }
        while (ret.length() < 8) {
            ret = 0 + ret;
        }
        return ret;
    }

    public int readLength(String input) {
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '1') {
                count += 1;
            } else {
                return count;
            }
        }
        return count;
    }

    public boolean validate(String[] dataStr, int startIndex, int length) {
        int matchCount = 0;
        for (int i = 0; i < length; i++) {
            if (startIndex + i >= dataStr.length || !dataStr[startIndex + i].startsWith("10")) {
                return false;
            }
            matchCount += 1;
        }
        return matchCount == length;
    }

    public boolean validUtf8(int[] data) {
        String[] dataStr = new String[data.length];
        for (int i = 0; i < data.length; i++) {
            dataStr[i] = int2binary(data[i]);
            System.out.println(dataStr[i]);
        }
        for (int i = 0; i < dataStr.length; ) {
            int length = readLength(dataStr[i]);
            if (length == 0) {
                i++;
            } else if (length == 1 || length > 4) {
                return false;
            } else {
                if (!validate(dataStr, i + 1, length - 1)) {
                    return false;
                }
                i += length;
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        System.out.println(new UTF8Validation().validUtf8(new int[]{197, 130, 1}));
//        System.out.println(new UTF8Validation().validUtf8(new int[]{235, 140, 4}));
//        System.out.println(new UTF8Validation().validUtf8(new int[]{145}));
//        System.out.println(new UTF8Validation().validUtf8(new int[]{240, 162, 138, 147, 145}));
        System.out.println(new UTF8Validation().validUtf8(new int[]{250, 145, 145, 145, 145}));
    }
}
