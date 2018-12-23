package strings;

public class StringCompression {
    public int compress(char[] chars) {
        if (chars.length <= 1) {
            return chars.length;
        }

        String ret = "";
        char lastChar = chars[0];
        int curCount = 1;

        for (int i = 1; i < chars.length; i++) {
            if (lastChar != chars[i]) {
                ret = ret + lastChar;
                if (curCount > 1) {
                    ret = ret + curCount;
                }
                if (i == chars.length - 1) {
                    ret = ret + chars[i];
                }
                lastChar = chars[i];
                curCount = 1;
            } else if (lastChar == chars[i]) {
                curCount += 1;
                if (i == chars.length - 1) {
                    ret = ret + lastChar;
                    ret = ret + curCount;
                }
            }
        }

        for (int i = 0; i < ret.length(); i++) {
            chars[i] = ret.charAt(i);
        }

        return ret.length();
    }

    public static void main(String args[]) {
        System.out.println(new StringCompression().compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}));
        System.out.println(new StringCompression().compress(new char[]{'a', 'b'}));
        System.out.println(new StringCompression().compress(new char[]{'a'}));
    }
}
