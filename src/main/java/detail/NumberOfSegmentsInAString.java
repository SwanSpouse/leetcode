
package detail;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if(s.length() == 0) {
            return 0;
        }
        String[] ret = s.split(" ");
        int count =0;
        for(int i =0; i < ret.length; i ++) {
            if(ret[i].trim().equals("")) {
                continue ;
            }
            count += 1;
        }
        return count;
    }
}
