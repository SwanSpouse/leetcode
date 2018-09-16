package detail;

import java.util.HashMap;

public class BullsAndCows {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> mapA = new HashMap<Character, Integer>();
        HashMap<Character, Integer> mapB = new HashMap<Character, Integer>();

        int countA = 0;
        int countB = 0;
        for (int i = 0; i < secret.length() && i < guess.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                countA += 1;
                continue;
            }
            if (mapA.containsKey(secret.charAt(i))) {
                mapA.put(secret.charAt(i), mapA.get(secret.charAt(i)) + 1);
            } else {
                mapA.put(secret.charAt(i), 1);
            }
            if (mapB.containsKey(guess.charAt(i))) {
                mapB.put(guess.charAt(i), mapB.get(guess.charAt(i)) + 1);
            } else {
                mapB.put(guess.charAt(i), 1);
            }
        }
        for (Character c : mapA.keySet()) {
            if (mapB.containsKey(c)) {
                countB += Math.min(mapA.get(c), mapB.get(c));
            }
        }
        return countA + "A" + countB + "B";
    }

    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1807", "7810"));
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
    }
}
