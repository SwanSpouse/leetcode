
package detail;

public class ToLowerCase {
    public String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i < str.length(); i ++) {
            if(str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append((char)(str.charAt(i) - 'A' + 'a'));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
