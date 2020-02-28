package array;

import utils.Print;

import java.util.ArrayList;

public class BeautifulArray {

    public int[] beautifulArray(int N) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);

        while (arr.size() < N) {
            ArrayList<Integer> temp = new ArrayList<>();
            for (Integer cur : arr) {
                if (cur * 2 - 1 <= N) {
                    temp.add(cur * 2 - 1);
                }
            }
            for (Integer cur : arr) {
                if (cur * 2 <= N) {
                    temp.add(cur * 2);
                }
            }
            arr = temp;
        }
        return arr.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Print.printArr(new BeautifulArray().beautifulArray(4));
    }
}
