package strings;

public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String S) {
        String ret = S;
        boolean containsDup = true;

        while (containsDup) {
            containsDup = false;
            StringBuffer sb = new StringBuffer();
            int index = 0;
            while (index < ret.length()) {
                if (index < ret.length() - 1 && ret.charAt(index) == ret.charAt(index + 1)) {
                    index += 2;
                    containsDup = true;
                    continue;
                }
                sb.append(ret.charAt(index++));
            }
            ret = sb.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString().removeDuplicates("abbaca"));
    }
}
