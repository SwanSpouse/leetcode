package detail;

class FindWordsThatCanBeFormedByCharacters {

    public boolean canBeFormed(int[] origin, int[] input) {
        for(int i =0; i < 26; i ++) {
            if (origin[i] < input[i]) {
                return false;
            }
        }
        return true;
    }

    public int[] charsToArr(String input) {
        int[] ret = new int[26];
        for(int i =0; i < input.length(); i ++) {
            ret[input.charAt(i)- 'a'] += 1;
        }
        return ret;
    }

    public int countCharacters(String[] words, String chars) {
        int[] origin = charsToArr(chars);

        int ret = 0 ;
        for(int i=0; i < words.length; i ++) {
            if (canBeFormed(origin, charsToArr(words[i]))) {
                ret += words[i].length();
            }
        }
        return ret;
    }
}