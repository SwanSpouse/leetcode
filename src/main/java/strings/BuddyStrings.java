package strings;

public class BuddyStrings {
    public boolean buddyStrings(String A, String B) {
        if (A.length() < 2 || A.length() != B.length()) {
            return false;
        }
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        boolean containsDup = false;
        for (int i = 0; i < A.length(); i++) {
            arr1[A.charAt(i) - 'a'] += 1;
            if (arr1[A.charAt(i) - 'a'] > 1) {
                containsDup = true;
            }
        }
        for (int i = 0; i < B.length(); i++) {
            arr2[B.charAt(i) - 'a'] += 1;
        }
        if (A.equals(B) && containsDup) {
            return true;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        int diffCount = 0;
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) != B.charAt(i)) {
                diffCount += 1;
            }
        }
        return diffCount == 2;
    }

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("ab", "ba"));
    }
}
