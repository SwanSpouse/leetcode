package strings;

public class GoatLatin {

    public String buildNewWord(String word) {
        if (word.length() == 0) {
            return word;
        }
        if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i' || word.charAt(0) == 'o' || word.charAt(0) == 'u') {
            return word + "ma";
        }
        if (word.charAt(0) == 'A' || word.charAt(0) == 'E' || word.charAt(0) == 'I' || word.charAt(0) == 'O' || word.charAt(0) == 'U') {
            return word + "ma";
        }
        return word.substring(1) + word.charAt(0) + "ma";
    }

    public String toGoatLatin(String S) {
        StringBuffer sb = new StringBuffer();

        String[] words = S.split(" ");
        for (int i = 0; i < words.length; i++) {
            String cur = buildNewWord(words[i]);
            for (int j = 0; j < i + 1; j++) {
                cur += "a";
            }
            sb.append(cur + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
        System.out.println(new GoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }
}
