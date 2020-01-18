package detail;

import java.util.*;

class DecryptStringFromAlphabetToIntegerMapping {
    
    public String freqAlphabets(String s) {
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");
        map.put("5", "e");
        map.put("6", "f");
        map.put("7", "g");
        map.put("8", "h");
        map.put("9", "i");
        map.put("10", "j");
        map.put("11", "k");
        map.put("12", "l");
        map.put("13", "m");
        map.put("14", "n");
        map.put("15", "o");
        map.put("16", "p");
        map.put("17", "q");
        map.put("18", "r");
        map.put("19", "s");
        map.put("20", "t");
        map.put("21", "u");
        map.put("22", "v");
        map.put("23", "w");
        map.put("24", "x");
        map.put("25", "y");
        map.put("26", "z");        

        String ret = "";
        int i = s.length()-1;
        while(i >= 0) {
            if (s.charAt(i) == '#') {
                ret = map.get(s.substring(i-2, i)) + ret;
                i -= 3;
            } else {
                ret = map.get(s.charAt(i)+"") + ret;
                i -= 1;
            }
        }
        return ret;
    }
}