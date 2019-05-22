/*
 * @lc app=leetcode id=211 lang=java
 *
 * [211] Add and Search Word - Data structure design
 *
 * https://leetcode.com/problems/add-and-search-word-data-structure-design/description/
 *
 * algorithms
 * Medium (29.68%)
 * Total Accepted:    109.3K
 * Total Submissions: 367.8K
 * Testcase Example:  '["WordDictionary","addWord","addWord","addWord","search","search","search","search"]\n[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]'
 *
 * Design a data structure that supports the following two operations:
 * 
 * 
 * void addWord(word)
 * bool search(word)
 * 
 * 
 * search(word) can search a literal word or a regular expression string
 * containing only letters a-z or .. A . means it can represent any one
 * letter.
 * 
 * Example:
 * 
 * 
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * 
 * 
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * 
 */
class Trie {
    Trie[] children;
    boolean isEnd;
    Trie() {
        children = new Trie[26];
        isEnd = false;
    }
}

class WordDictionary {

    /** Initialize your data structure here. */

    Trie root;

    public WordDictionary() {
        root = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Trie p = root;
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);
            if (p.children[cur - 'a'] == null) p.children[cur - 'a'] = new Trie();
            p = p.children[cur - 'a'];
            if (i == word.length() - 1) {
                p.isEnd = true;
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return helper(word, root, 0);
    }

    public boolean helper (String word, Trie node, int level) {
        if (node == null) return false;
        if (level == word.length()) return node.isEnd;
        if (word.charAt(level) == '.') {
            for (Trie child : node.children) {
                boolean b = helper(word, child, level + 1);
                if (b) return true;
            }
        } else {
            if (node.children[word.charAt(level) - 'a'] != null) {
                return helper(word, node.children[word.charAt(level) - 'a'], level + 1);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
