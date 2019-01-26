package sort_and_search;

public class FindSmallestLetterGreaterThanTarget {
    public char nextGreatestLetter(char[] letters, char target) {
        int ret = -1;
        int left = 0, right = letters.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                ret = mid;
                right = mid - 1;
            }
        }
        return ret == -1 ? letters[0] : letters[ret];
    }

    public static void main(String[] args) {
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'));
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'));
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'd'));
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'g'));
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'j'));
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'k'));
        System.out.println(new FindSmallestLetterGreaterThanTarget().nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e'));
    }
}
