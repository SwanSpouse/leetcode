package strings;

public class UncommonWordsFromTwoSentences {
    public String[] uncommonFromSentences(String A, String B) {
        HashMap<String, Integer> mapA = new HashMap<String, Integer>();
        HashMap<String, Integer> mapB = new HashMap<String, Integer>();

        String[] fieldsA = A.split(" ");
        String[] fieldsB = B.split(" ");

        for(String s : fieldsA) {
            if( mapA.containsKey(s) ) {
                mapA.put(s, mapA.get(s) + 1);
            } else {
                mapA.put(s, 1);
            }
        }
        for(String s : fieldsB) {
            if( mapB.containsKey(s) ) {
                mapB.put(s, mapB.get(s) + 1);
            } else {
                mapB.put(s, 1);
            }
        }
        List<String> ret = new ArrayList<String>();
        for(String s : fieldsA) {
            if(mapB.containsKey(s) || mapA.get(s) > 1) {
                continue ;
            }
            ret.add(s);
        }
        for(String s: fieldsB) {
            if(mapA.containsKey(s) || mapB.get(s) > 1) {
                continue ;
            }
            ret.add(s);
        }
        String[] retArr = new String[ret.size()];
        for(int i =0; i < ret.size(); i ++) {
            retArr[i] = ret.get(i);
        }
        return retArr;
    }
}
