package array;

public class BaseballGame {

    public int calPoints(String[] ops) {
        int[] list = new int[ops.length];
        int index = 0;

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                index -= 1;
            } else if (ops[i].equals("D")) {
                list[index] = list[index - 1] * 2;
                index += 1;
            } else if (ops[i].equals("+")) {
                list[index] = list[index - 1] + list[index - 2];
                index += 1;
            } else {
                list[index] = Integer.parseInt(ops[i]);
                index += 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < index; i++) {
            sum += list[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new BaseballGame().calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"}));
    }
}
