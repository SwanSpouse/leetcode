package strings;

/**
 * 细节题，就是考笔算乘法。
 */
class MultiplyStrings {
    public static String add(String num1, String num2) {
        int index1 = num1.length() - 1;
        int index2 = num2.length() - 1;

        int carry = 0;
        String ret = "";
        while (index1 >= 0 || index2 >= 0) {
            int value1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
            int value2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
            ret = (value1 + value2 + carry) % 10 + ret;
            carry = (value1 + value2 + carry) / 10;

            index1 -= 1;
            index2 -= 1;
        }
        if (carry != 0) {
            ret = carry + ret;
        }
        return ret;
    }

    public static String multiply(String num1, String num2) {
        String ret = "0";
        if(num1.equals("0") || num2.equals("0")) {
            return ret;
        }
        String base = "";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            String cur = "";
            if (num1.charAt(i) != '0') {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    int value1 = num1.charAt(i) - '0';
                    int value2 = num2.charAt(j) - '0';
                    cur = (value1 * value2 + carry) % 10 + cur;
                    carry = (value1 * value2 + carry) / 10;
                }
            }
            cur = carry != 0 ? carry + cur + base : cur + base;
            base += "0";
            ret = add(ret, cur);
        }
        return ret;
    }

    public static void main(String[] args) {
//        System.out.println(add("0", "1"));
        System.out.println(multiply("999", "100"));
    }
}