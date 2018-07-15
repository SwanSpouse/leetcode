package array;

import java.util.*;

public class LargestNumber {

    public static String largestNumber(int[] nums) {
        ArrayList<String> list = new ArrayList<String>();
        for (int num : nums) {
            list.add("" + num);
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int cur1 = 0;
                int cur2 = 0;
                while (cur1 < o1.length() || cur2 < o2.length()) {
                    char c1 = cur1 < o1.length() ? o1.charAt(cur1++) : o1.charAt(0);
                    char c2 = cur2 < o2.length() ? o2.charAt(cur2++) : o2.charAt(0);
                    if (c1 < c2) {
                        return 1;
                    } else if (c1 > c2) {
                        return -1;
                    }
                }
                return 0;
            }
        });

        String ret = "";
        for (String item : list) {
            ret += item;
        }
        if (ret.replaceAll("0", "").length() == 0) {
            return "0";
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{824, 938, 1399, 5607, 6973, 5703, 9609, 4398, 8247}));
        System.out.println(largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(largestNumber(new int[]{34, 331, 30, 3, 31}));
        System.out.println(largestNumber(new int[]{121, 12}));
    }
}

//824,938,1399,5607,6973,5703,9609,4398,8247
//
//9609 938 8247 824 6973 5703 5607 4398 1399
//9609 938 824 8247 6973 5703 5607 4398 1399