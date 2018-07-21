package array;

import java.util.HashSet;

public class HappyNumber {

    public int nextNum(int n) {
        int ret = 0;
        while (n != 0) {
            ret = ret + (n % 10) * (n % 10);
            n = n / 10;
        }
        return ret;
    }

    public boolean isHappy(int n) {
        HashSet<Integer> dict = new HashSet<Integer>();
        while (n != 1) {
            int next = nextNum(n);
            if (dict.contains(next)) {
                return false;
            } else {
                dict.add(next);
                n = next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(3));
    }

}
