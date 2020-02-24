package strings;

import java.util.ArrayList;
import java.util.List;

public class PrintWordsVertically {

    public String trimSuffix(String s) {
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                return s.substring(0, i + 1);
            }
        }
        return s;
    }

    public List<String> printVertically(String s) {
        String[] fields = s.split(" ");
        ArrayList<String> vertical = new ArrayList<>();

        for (int pos = 0; ; pos++) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < fields.length; i++) {
                if (pos < fields[i].length()) {
                    sb.append(fields[i].charAt(pos));
                } else {
                    sb.append(" ");
                }
            }
            if (sb.toString().trim().length() == 0) {
                break;
            }
            vertical.add(trimSuffix(sb.toString()));
        }
        return vertical;
    }
}
