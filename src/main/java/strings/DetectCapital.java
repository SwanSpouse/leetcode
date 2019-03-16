package strings;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) {
            return true;
        }
        boolean isAllLower = true, isAllUpper = true, firstLetterUpper = false;
        firstLetterUpper = 'A' <= word.charAt(0) && word.charAt(0) <= 'Z';
        for (int i = 1; i < word.length(); i++) {
            if ('A' <= word.charAt(i) && word.charAt(i) <= 'Z') {
                isAllLower = false;
            } else if ('a' <= word.charAt(i) && word.charAt(i) <= 'z') {
                isAllUpper = false;
            }
        }
        return isAllLower || (isAllUpper && firstLetterUpper);
    }
}
