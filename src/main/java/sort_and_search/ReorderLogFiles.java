package sort_and_search;

import utils.Print;

import java.util.ArrayList;
import java.util.Collections;

public class ReorderLogFiles {

    static class LogItem implements Comparable {
        public String identifier;
        public String[] words;

        @Override
        public int compareTo(Object o) {
            LogItem another = (LogItem) o;
            for (int i = 0; i < this.words.length && i < another.words.length; i++) {
                if (this.words[i].equals(another.words[i])) {
                    continue;
                }
                return this.words[i].compareTo(another.words[i]);
            }
            return this.words.length - another.words.length;
        }

        @Override
        public String toString() {
            StringBuffer sb = new StringBuffer(this.identifier);
            for (int i = 0; i < words.length; i++) {
                sb.append(" " + words[i]);
            }
            return sb.toString();
        }
    }

    public boolean isAllLetter(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < 'a' || input.charAt(i) > 'z') {
                return false;
            }
        }
        return true;
    }

    public String[] reorderLogFiles(String[] logs) {
        ArrayList<LogItem> letterLogs = new ArrayList<>();
        ArrayList<LogItem> digits = new ArrayList<>();

        for (String log : logs) {
            String[] fields = log.split(" ");
            LogItem item = new LogItem();
            item.identifier = fields[0];
            item.words = new String[fields.length - 1];

            for (int i = 1, index = 0; i < fields.length; i++) {
                item.words[index++] = fields[i];
            }
            if (isAllLetter(fields[1])) {
                letterLogs.add(item);
            } else {
                digits.add(item);
            }
        }
        Collections.sort(letterLogs);
        String[] ret = new String[logs.length];
        int index = 0;
        for (int i = 0; i < letterLogs.size(); i++) {
            ret[index++] = letterLogs.get(i).toString();
        }

        for (int i = 0; i < digits.size(); i++) {
            ret[index++] = digits.get(i).toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new ReorderLogFiles().reorderLogFiles(new String[]{"a1 9 2 3 1", "g1 act car", "zo4 4 7", "ab1 off key dog", "a8 act zoo"}));
    }
}
