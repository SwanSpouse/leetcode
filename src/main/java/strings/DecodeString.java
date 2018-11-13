package strings;

public class DecodeString {

    private int index = 0;

    private boolean isNumber(Character c) {
        return c >= '0' && c <= '9';
    }

    private boolean isAlpha(Character c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public String readString(String s) {

        System.out.println("======>>>" + s.substring(this.index));

        StringBuffer ret = new StringBuffer();
        StringBuffer sub = new StringBuffer();
        int number = 0;
        while (index < s.length()) {
            while (isNumber(s.charAt(index))) {
                number = number * 10 + s.charAt(index) - '0';
                this.index += 1;
            }
            if (index < s.length() && s.charAt(index) == '[') {
                this.index += 1;
            }
            while (index < s.length() && (isAlpha(s.charAt(index)) || isNumber(s.charAt(index)))) {
                if (isAlpha(s.charAt(index))) {
                    sub.append(s.charAt(index));
                    index += 1;
                } else {
                    sub.append(readString(s));
                }
            }
            if (index == s.length() || (index < s.length() && s.charAt(index) == ']')) {
                ret.append(sub.toString());
                for (int i = 0; i < number - 1; i++) {
                    ret.append(sub.toString());
                }
                this.index += 1;
                sub = new StringBuffer();
                number = 0;

            }
        }
        return ret.toString();
    }

    public String decodeString(String s) {
        this.index = 0;
        StringBuffer ret = new StringBuffer();

        while (index < s.length()) {
            ret.append(readString(s));
        }
        return ret.toString();
    }

    public static void main(String[] args) {
//        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
//        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
//        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
//        System.out.println(new DecodeString().decodeString("2[abc]"));
//        System.out.println(new DecodeString().decodeString("abc"));
        System.out.println(new DecodeString().decodeString("2[abc]3[c2[abc]d]ef"));
    }
}

// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".