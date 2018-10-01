package strings;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        String ret = "";
        int carry = 0;
        for(int i1 =num1.length()-1, i2=num2.length()-1; i1 >= 0 || i2 >= 0; i1 --, i2 --) {
            int n1 = i1 >= 0 ? num1.charAt(i1) - '0' : 0;
            int n2 = i2 >= 0 ? num2.charAt(i2) - '0' : 0;
            ret = (n1 + n2 + carry) % 10 + ret;
            carry = (n1 + n2 + carry) / 10;
        }
        if(carry == 1) {
            ret =  "1" + ret;
        }
        return ret;
    }
}
