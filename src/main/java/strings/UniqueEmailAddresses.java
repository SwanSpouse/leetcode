package strings;

import java.util.HashSet;

public class UniqueEmailAddresses {

    public String formatLocalName(String localName) {
        StringBuffer sb = new StringBuffer();
        for (Character c : localName.toCharArray()) {
            if (c == '+') {
                break;
            } else if (c == '.') {
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();
        for (String email : emails) {
            String[] fields = email.split("@");
            String localName = fields[0];
            String domain = fields[1];
            set.add(formatLocalName(localName) + "@" + domain);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new UniqueEmailAddresses().numUniqueEmails(new String[]{
                "test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"
        }));
    }

}
