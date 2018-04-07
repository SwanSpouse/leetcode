package detail;

/**
 * 细节题，应该不难。不应该用List, 如果位数一样，则复用digits，如果位数不一样，则新建立一个比digits长一个的数组
 */
class PlusOne {

    public static int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int cur = (carry + digits[i]) % 10;
            carry = (carry + digits[i]) / 10;
            digits[i] = cur;
        }
        if (carry == 0) {
            return digits;
        }
        int[] ret = new int[digits.length + 1];
        for (int i = 1; i < ret.length; i++) {
            ret[i] = digits[i - 1];
        }
        ret[0] = 1;
        return ret;
    }
}