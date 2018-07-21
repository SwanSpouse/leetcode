package tree;

public class Trie {

    boolean stopSign; // 标志一个节点是否是一个单词的结束
    Trie[] leaves; // 叶子节点 每个字母是一个节点

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        stopSign = false;
        leaves = new Trie[26];
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.leaves[word.charAt(i) - 'a'] == null) {
                cur.leaves[word.charAt(i) - 'a'] = new Trie();
            }
            cur = cur.leaves[word.charAt(i) - 'a'];
            if (i == word.length() - 1) {
                cur.stopSign = true;
            }
        }
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); i++) {
            if (cur.leaves[word.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.leaves[word.charAt(i) - 'a'];
        }
        return cur.stopSign == true;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); i++) {
            if (cur.leaves[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            cur = cur.leaves[prefix.charAt(i) - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie obj = new Trie();
        obj.insert("apple");
        obj.insert("asdfadfa");
        System.out.println(obj.search("asd"));
        System.out.println(obj.search("apple"));
        System.out.println(obj.startsWith("appl"));
    }
}
