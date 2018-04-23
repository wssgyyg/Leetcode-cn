public class No208 {

}

/*
class Trie {

    private TrieNode root;
    */
/** Initialize your data structure here. *//*

    public Trie() {
        root = new TrieNode();
    }

    */
/** Inserts a word into the trie. *//*

    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.children[ch - 'a'] == null) {
                p.children[ch - 'a'] = new TrieNode();
            }
            p = p.children[ch - 'a'];
        }
        p.isWord = true;
    }

    */
/** Returns if the word is in the trie. *//*

    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (p.children[ch - 'a'] == null) {
                return false;
            }
            p = p.children[ch - 'a'];
        }

        return p.isWord;
    }

    */
/** Returns if there is any word in the trie that starts with the given prefix. *//*

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (p.children[ch - 'a'] == null) return false;
            p = p.children[ch - 'a'];
        }
        return true;
    }
}

class TrieNode {
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;

    public TrieNode() {

    }
}*/
