package sort_and_search;

import utils.Print;

import java.util.Arrays;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ret = new int[deck.length];

        ret[deck.length - 1] = deck[deck.length - 1];
        for (int i = deck.length - 2; i >= 0; i--) {
            ret[i] = deck[i];
            int temp = ret[ret.length - 1];
            for (int j = ret.length - 2; j > i; j--) {
                ret[j + 1] = ret[j];
            }
            ret[i + 1] = temp;
        }
        return ret;
    }

    public static void main(String[] args) {
        Print.printArr(new RevealCardsInIncreasingOrder().deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7}));
    }
}
