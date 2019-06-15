package detail;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String a, String b) {
        String[] valuesA = a.split("\\+");
        String[] valuesB = b.split("\\+");

        // 实部
        int realQuantityA = Integer.parseInt(valuesA[0]);
        int realQuantityB = Integer.parseInt(valuesB[0]);
        // 虚部
        int imaginaryQuantityA = Integer.parseInt(valuesA[1].replace("i", ""));
        int imaginaryQuantityB = Integer.parseInt(valuesB[1].replace("i", ""));

        int realQuantityRet = realQuantityA * realQuantityB - imaginaryQuantityA * imaginaryQuantityB;
        int imaginaryQuantityRet = realQuantityA * imaginaryQuantityB + realQuantityB * imaginaryQuantityA;

        return realQuantityRet + "+" + imaginaryQuantityRet + "i";
    }

    public static void main(String[] args) {
//        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("1+1i", "1+1i"));
//        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(new ComplexNumberMultiplication().complexNumberMultiply("1+-1i", "0+0i"));
    }
}
