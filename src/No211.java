public class No211 {

}

class WordDictionary {
    private Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.insert(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.searchRegix(word);
    }
}

class Trie {
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

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

    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (p.children[ch - 'a'] == null) {
                return false;
            }
            p = p.children[ch - 'a'];
        }

        return true;
    }

    public boolean searchRegix(String wordRegix) {
        return searchRegix(wordRegix, root);
    }

    private boolean searchRegix(String wordRegix, TrieNode root) {
        if (root == null && wordRegix.length() == 0) return true;
        if (root == null) return false;
        TrieNode p = root;
        for (int i = 0; i < wordRegix.length(); i++) {
            char ch = wordRegix.charAt(i);
            if (ch == '.') {
                for (int j = 0; j < 26; j++) {
                    if (p.children[j] != null && searchRegix(wordRegix.substring(i + 1), p.children[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                if (p.children[ch - 'a'] == null) {
                    return false;
                }
                p = p.children[ch - 'a'];
            }
        }

        return p.isWord;
    }
}

class TrieNode {
    public boolean isWord;
    public TrieNode[] children = new TrieNode[26];
    public TrieNode() {

    }
}

