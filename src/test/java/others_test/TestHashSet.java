package others_test;

import java.util.HashSet;

public class TestHashSet {

    public static void main(String[] args) {
        HashSet<Integer> s1 = new HashSet<Integer>();
        HashSet<Integer> s2 = new HashSet<Integer>();

        System.out.println(s1.containsAll(s2) && s2.containsAll(s1));

        s1.add(1);
        s2.add(1);
        System.out.println(s1.containsAll(s2) && s2.containsAll(s1));

        s1.add(2);
        System.out.println(s1.containsAll(s2) && s2.containsAll(s1));

    }
}
