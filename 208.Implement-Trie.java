class Trie {

    /** Initialize your data structure here. */
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (pointer.children[cur - 'a'] == null) {
                pointer.children[cur - 'a'] = new TrieNode();
            } 
            pointer = pointer.children[cur - 'a'];
        }
        pointer.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode pointer = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (pointer.children[cur - 'a'] == null) {
                return false;
            }
            pointer = pointer.children[cur - 'a'];
        }
        return pointer.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode pointer = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (pointer.children[cur - 'a'] == null) {
                return false;
            }
            pointer = pointer.children[cur - 'a'];
        }
        return true;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children = new TrieNode[26]; 
    TrieNode () {
        this.isEnd = false;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
