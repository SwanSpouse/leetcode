package array;


public class BinaryNumberWithAlternatingBits {

    public String covertToBinary(int n) {
        StringBuffer sb = new StringBuffer();
        while (n != 0) {
            sb.append(n % 2);
            n = n / 2;
        }
        return sb.toString();
    }

    public boolean hasAlternatingBits(int n) {
        String binary = covertToBinary(n);
        boolean shouldBeOne = binary.charAt(0) == '1';
        for (int i = 0; i < binary.length(); i++) {
            if ((shouldBeOne && binary.charAt(i) == '1') || (!shouldBeOne && binary.charAt(i) == '0')) {
                shouldBeOne = !shouldBeOne;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(5));
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(7));
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(11));
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(10  ));
    }
}
