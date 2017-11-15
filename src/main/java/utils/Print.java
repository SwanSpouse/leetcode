package utils;

import java.util.HashMap;

public class Print {
    public static void PrintMap(HashMap<? extends Object, ? extends Object> map) {
        for (Object key : map.keySet()) {
            System.out.print("{" + key + ":" + map.get(key) + "}");
        }
        System.out.println();
    }
}
