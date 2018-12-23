package detail;

import utils.Print;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount {

    public static List<String> subdomainVisits(String[] cpdomains) {
        List<String> ret = new ArrayList<String>();
        HashMap<String, Integer> count = new HashMap<String, Integer>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] fields = cpdomains[i].split(" ");
            int times = Integer.parseInt(fields[0]);
            String[] domains = fields[1].split("\\.");
            String cur = "";
            for (int index = domains.length - 1; index >= 0; index--) {
                cur = cur.equals("") ? domains[index] : domains[index] + "." + cur;
                if (count.containsKey(cur)) {
                    count.put(cur, count.get(cur) + times);
                } else {
                    count.put(cur, times);
                }
            }
        }

        for (String key : count.keySet()) {
            String cur = count.get(key) + " " + key;
            ret.add(cur);
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
        Print.printList(subdomainVisits(new String[]{"9001 discuss.leetcode.com", "9001 discuss.leetcode.com"}));
    }
}
