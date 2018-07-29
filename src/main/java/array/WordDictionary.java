package array;

public class WordDictionary {

    char val;
    boolean isEnd;
    WordDictionary[] subNodes;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        this.isEnd = false;
        this.subNodes = new WordDictionary[26];
    }

    WordDictionary(char val) {
        this.val = val;
        this.isEnd = false;
        this.subNodes = new WordDictionary[26];
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            WordDictionary newNode = cur.subNodes[word.charAt(i) - 'a'] == null ? new WordDictionary(word.charAt(i)) : cur.subNodes[word.charAt(i) - 'a'];
            cur.subNodes[word.charAt(i) - 'a'] = newNode;
            if (i == word.length() - 1) {
                newNode.isEnd = true;
            }
            cur = newNode;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        WordDictionary cur = this;
        for (int i = 0; i < word.length(); i++) {
            // 1. word[i]!='.' 并且相应位置为null，说明没有匹配上，返回false
            // 2. word[i]!='.' 并且相应位置不为null，说明匹配上了，则需要进行后续匹配；如果匹配到最后一位了，则需要判断是否有结束符。
            // 3. word[i]=='.' 找到word中不为null的字段，递归匹配
            if (word.charAt(i) != '.' && cur.subNodes[word.charAt(i) - 'a'] == null) {
                return false;
            } else if (word.charAt(i) != '.' && cur.subNodes[word.charAt(i) - 'a'] != null) {
                cur = cur.subNodes[word.charAt(i) - 'a'];
                if (i == word.length() - 1) {
                    return cur.isEnd;
                }
            } else if (word.charAt(i) == '.') {
                for (int index = 0; index < cur.subNodes.length; index++) {
                    if (cur.subNodes[index] == null) {
                        continue;
                    }
                    if (cur.subNodes[index].search(word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
        }
        return cur.isEnd;
    }

    @Override
    public String toString() {
        return "val:" + this.val + " stop:" + this.isEnd;
    }

    public static void main(String[] args) {
        WordDictionary obj = new WordDictionary();
//        obj.addWord("bad");
//        obj.addWord("a");
//        obj.addWord("dad");
//        obj.addWord("mad");
//        boolean param1 = obj.search("pad"); // false
//        boolean param2 = obj.search("bad"); // true
//        boolean param3 = obj.search(".ad"); // true
//        boolean param4 = obj.search("b.."); // true
//        System.out.println(param1);
//        System.out.println(param2);
//        System.out.println(param3);
//        System.out.println(param4);


        obj.addWord("at");
        obj.addWord("and");
        obj.addWord("an");
        obj.addWord("add");
        System.out.println(obj.search("a")); // false
        System.out.println(obj.search(".at")); // false
        obj.addWord("bat");
        System.out.println(obj.search(".at")); // true
        System.out.println(obj.search("an.")); // true
        System.out.println(obj.search("a.d.")); // false
        System.out.println(obj.search("b.")); // false
        System.out.println(obj.search("a.d")); // true
        System.out.println(obj.search(".")); // false
    }
}
