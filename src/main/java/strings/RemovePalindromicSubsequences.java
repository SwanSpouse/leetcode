package strings;

public class RemovePalindromicSubsequences {

    public boolean isPalindrome(String s) {
        for (int left = 0, right = s.length() - 1; left <= right; left++, right--) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
        }
        return true;
    }

    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        }
        int step = 0;

        return step;
    }
}
