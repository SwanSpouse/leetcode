package detail;

public class PalindromeNumber {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
           return false;
        }
        int ret = 0;
        long origin = x;
        while (x != 0) {
            ret = ret * 10 + x % 10;
            x = x / 10;
        }
        return ret == origin;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-2147447412));
    }
}

