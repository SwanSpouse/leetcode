package utils;

import java.util.HashMap;
import java.util.List;

public class Print {
    public static void PrintMap(HashMap<? extends Object, ? extends Object> map) {
        if (map == null) {
            System.out.println("NULL");
            return;
        }
        for (Object key : map.keySet()) {
            System.out.print("{" + key + ":" + map.get(key) + "}");
        }
        System.out.println();
    }

    public static void PrintList(List<? extends Object> list) {
        if (list == null) {
            System.out.println("NULL");
            return;
        }
        for (Object item : list) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void Print2DIntegerList(List<List<Integer>> board) {
        if (board == null) {
            System.out.println("NULL");
            return;
        }
        for (List<Integer> list : board) {
            if (list == null) {
                System.out.println("NULL");
                continue;
            }
            for (Object item : list) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }
    }

    public static void PrintArr(int[] arr) {
        for (int item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void PrintArr(boolean[] arr) {
        for (boolean item : arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
    }

    public static void Print2DArr(char[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void Print2DArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
