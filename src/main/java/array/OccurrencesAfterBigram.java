package array;

import utils.Print;

import java.util.ArrayList;

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> ret = new ArrayList<>();
        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 2; i++) {
            if (words[i].equals(first) && words[i + 1].equals(second)) {
                ret.add(words[i + 2]);
            }
        }
        String[] temp = new String[ret.size()];
        for (int i = 0; i < ret.size(); i++) {
            temp[i] = ret.get(i);
        }
        return temp;
    }

    public static void main(String[] args) {
        Print.printArr(new OccurrencesAfterBigram().findOcurrences("alice is a good girl she is a good student", "a", "good"));
    }
}
