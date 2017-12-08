package strings;

public class IntegerToRoman {

    public static String appendChar(String input, int nums, char ch) {
        for(int i=0; i < nums; i ++ ){
            input += ch;
        }
        return input;
    }

    public static String intToRoman(int num) {
        return "";
    }
}
