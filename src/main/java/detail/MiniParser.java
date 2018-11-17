package detail;

public class MiniParser {

    private int index;

    public NestedInteger readNestedInteger(String s) {
        while (index < s.length() && s.charAt(index) == ',') {
            index += 1;
        }
        if (s.charAt(index) == '[') {
            index += 1;
            NestedInteger ni = new NestedInteger();
            while (index < s.length() && s.charAt(index) != ']') {
                ni.add(readNestedInteger(s));
            }
            index += 1;
            return ni;
        } else {
            String cur = "";
            while (index < s.length() && s.charAt(index) != ',' && s.charAt(index) != ']') {
                cur += s.charAt(index++);
            }
            if (index < s.length() && s.charAt(index) != ']') {
                index += 1;
            }
            if (cur.length() == 0) {
                return new NestedInteger();
            }
            return new NestedInteger(Integer.parseInt(cur));
        }
    }

    public NestedInteger deserialize(String s) {
        this.index = 0;
        return readNestedInteger(s);
    }
}
