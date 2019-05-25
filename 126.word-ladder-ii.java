import java.util.List;
import java.util.Map;

/*
 * [126] Word Ladder II
 *
 * https://leetcode.com/problems/word-ladder-ii/description/
 *
 * algorithms
 * Hard (17.66%)
 * Total Accepted:    119.5K
 * Total Submissions: 676.2K
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such
 * that:
 * 
 * 
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 * 
 * 
 * Note:
 * 
 * 
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * 
 * Output:
 * [
 * ⁠ ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * 
 * Output: []
 * 
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 * 
 * 
 * 
 * 
 * 
 */
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Set<String> toVisit = new HashSet<>(wordList);
        if (!toVisit.contains(endWord)) return res;
        Map<String, String> parent = new HashMap<>();
        Queue<String> q =  new LinkedList<>();
        q.add(beginWord);
        q.add(null);
        while (q.size() != 1 || q.peek() != null) {
            String cur = q.poll();
            if (cur == null) {
                if (res.size() != 0) return res;
                q.add(null);
            } else {
                toVisit.remove(cur);
                List<String> children = findChildren(toVisit, cur);
                for (String child : children) {
                    parent.put(child, cur);
                    
                    if (child.equals(endWord)) {
                        
                        res.add(generatePath(parent, endWord));
                    } else {
                        q.add(child);
                    }
                }
            }
        }
        return res;
    }

    public List<String> generatePath(Map<String, String> parent, String endWord) {
        List<String> path = new ArrayList<>();
        path.add(endWord);
        String s = endWord;
        while(parent.containsKey(s)) {
            path.add(0, parent.get(s));
            s = parent.get(s);
        }
        return path;
    }

    public List<String> findChildren(Set<String> toVisit, String cur) {
        List<String> children = new ArrayList<>();
        for (String s : toVisit) {
            int count = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != cur.charAt(i)) count++;
            }
            if (count == 1) children.add(s);
        }
        return children;
    }
}
