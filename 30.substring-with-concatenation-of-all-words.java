import java.util.Map;

/*
 * [30] Substring with Concatenation of All Words
 *
 * https://leetcode.com/problems/substring-with-concatenation-of-all-words/description/
 *
 * algorithms
 * Hard (23.55%)
 * Total Accepted:    132.4K
 * Total Submissions: 562.1K
 * Testcase Example:  '"barfoothefoobarman"\n["foo","bar"]'
 *
 * You are given a string, s, and a list of words, words, that are all of the
 * same length. Find all starting indices of substring(s) in s that is a
 * concatenation of each word in words exactly once and without any intervening
 * characters.
 * 
 * Example 1:
 * 
 * 
 * Input:
 * ⁠ s = "barfoothefoobarman",
 * ⁠ words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar"
 * respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input:
 * ⁠ s = "wordgoodgoodgoodbestword",
 * ⁠ words = ["word","good","best","word"]
 * Output: []
 * 
 * 
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words.length == 0) return res;
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        int n = words.length, len = words[0].length();
        for (int i = 0; i + n * len - 1 < s.length(); i++) {
            if (match(s.substring(i, i + n * len), count, len)) {
                res.add(i);
            }
        }
        return res;
    }

    public boolean match(String cur, Map<String, Integer> count, int len) {
        int p = 0;
        Map<String, Integer> map = new HashMap<>();
        while (p < cur.length()) {
            String s = cur.substring(p, p + len);
            if (count.containsKey(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
                if (count.get(s) < map.get(s)) return false;
            } else {
                return false;
            }
            p += len;
        }
        return true;
    }
}
