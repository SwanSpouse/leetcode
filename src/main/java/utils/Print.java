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

    public static void PrintArr(List<? extends  Object> list) {
        for(Object item : list) {
            System.out.print(" ,");
        }
        System.out.println();
    }
}
