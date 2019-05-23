/*
 * [212] Word Search II
 *
 * https://leetcode.com/problems/word-search-ii/description/
 *
 * algorithms
 * Hard (28.56%)
 * Total Accepted:    111.3K
 * Total Submissions: 389.8K
 * Testcase Example:  '[["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]]\n["oath","pea","eat","rain"]'
 *
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: 
 * board = [
 * ⁠ ['o','a','a','n'],
 * ⁠ ['e','t','a','e'],
 * ⁠ ['i','h','k','r'],
 * ⁠ ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * All inputs are consist of lowercase letters a-z.
 * The values of words are distinct.
 * 
 * 
 */
class Solution {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = new TrieNode();
        build(root, words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int x, int y, TrieNode root, List<String> res) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        char cur = board[x][y];
        if (cur == '#' || root.children[cur - 'a'] == null) return;
        if (root.children[cur - 'a'].word != null) {
            res.add(root.children[cur - 'a'].word);
            root.children[cur - 'a'].word = null;
        }
        root = root.children[cur - 'a'];
        board[x][y] = '#';
        dfs(board, x + 1, y, root, res);
        dfs(board, x - 1, y, root, res);
        dfs(board, x, y + 1, root, res);
        dfs(board, x, y - 1, root, res);
        board[x][y] = cur;
    }

    public void build(TrieNode node, String[] words) {
        for (String word : words) {
            TrieNode p = node;
            for (int i = 0; i < word.length(); i++) {
                if (p.children[word.charAt(i) - 'a'] == null) {
                    p.children[word.charAt(i) - 'a'] = new TrieNode();
                }
                p = p.children[word.charAt(i) - 'a'];
            }
            p.word = word;
        }
    }
}
