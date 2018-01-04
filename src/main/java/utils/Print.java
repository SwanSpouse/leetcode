package utils;

import java.util.HashMap;
import java.util.List;

public class Print {
    public static void PrintMap(HashMap<? extends Object, ? extends Object> map) {
        for (Object key : map.keySet()) {
            System.out.print("{" + key + ":" + map.get(key) + "}");
        }
        System.out.println();
    }

    public static void PrintList(List<? extends  Object> list) {
        for(Object item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void PrintArr(int[] arr) {
        for(int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }
}
