package strings;

public class GreatestCommonDivisorOfStrings {

    public String repeatedItem(String input, int len) {
        if (len == 1) {
            return input;
        }
        if (input.length() % len != 0) {
            return "";
        }
        String item = input.substring(0, len);
        int index = len;
        while (index + len < input.length()) {
            if (!item.equals(input.substring(index, index + len))) {
                return "";
            }
            index += len;
        }
        return item;
    }

    public String gcdOfStrings(String str1, String str2) {
        String longString = str1, shortString = str2;
        if (str1.length() < str2.length()) {
            longString = str2;
            shortString = str1;
        }
        for (int i = shortString.length(); i > 0; i--) {
            String shortItem = repeatedItem(shortString, i);
            String longItem = repeatedItem(longString, i);
            if (shortItem.length() > 0 && shortItem.equals(longItem)) {
                return shortItem;
            }
        }
        return "";
    }

    public static void main(String[] args) {
//        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("ABCABC", "ABC"));
//        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("ABABAB", "AB"));
//        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("LEET", "CODE"));
        System.out.println(new GreatestCommonDivisorOfStrings().gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX", "TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}

