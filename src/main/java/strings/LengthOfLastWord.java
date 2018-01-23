package strings;

class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if(s.trim().length() == 0) {
            return 0;
        }
        String[] values = s.trim().split(" ");
        return values[values.length-1].length();
    }
}