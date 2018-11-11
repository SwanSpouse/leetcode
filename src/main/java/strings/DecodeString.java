package strings;

public class DecodeString {

    public String decodeString(String s) {
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
        System.out.println(new DecodeString().decodeString("3[a2[c]]"));
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }
}

// s = "3[a]2[bc]", return "aaabcbc".
// s = "3[a2[c]]", return "accaccacc".
// s = "2[abc]3[cd]ef", return "abcabccdcdcdef".