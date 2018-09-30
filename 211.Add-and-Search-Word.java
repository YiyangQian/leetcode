class WordDictionary {

    /** Initialize your data structure here. */
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(root, word, 0);
    }
    
    public boolean helper(TrieNode root, String word, int index) {
        if (index == word.length()) {
            return root.isEnd;
        }
        boolean res = false;
        char target = word.charAt(index);
        if (target == '.') {
            for (int i = 0; i < 26; i++) {
                if (root.children[i] != null) {
                    res = res || helper(root.children[i], word, index + 1);
                }
            }
        } else {
            if (root.children[target - 'a'] != null) {
                return helper(root.children[target - 'a'], word, index + 1);
            } else {
                return false;
            }
        }
        return res;
    }
}

class TrieNode {
    boolean isEnd;
    TrieNode[] children = new TrieNode[26];
    TrieNode () {
        isEnd = false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
