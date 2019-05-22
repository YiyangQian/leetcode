/*
 * @lc app=leetcode id=76 lang=java
 *
 * [76] Minimum Window Substring
 *
 * https://leetcode.com/problems/minimum-window-substring/description/
 *
 * algorithms
 * Hard (30.23%)
 * Total Accepted:    222.3K
 * Total Submissions: 735.1K
 * Testcase Example:  '"ADOBECODEBANC"\n"ABC"'
 *
 * Given a string S and a string T, find the minimum window in S which will
 * contain all the characters in T in complexity O(n).
 * 
 * Example:
 * 
 * 
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 * 
 * 
 * Note:
 * 
 * 
 * If there is no such window in S that covers all characters in T, return the
 * empty string "".
 * If there is such window, you are guaranteed that there will always be only
 * one unique minimum window in S.
 * 
 */
class Solution {
    public String minWindow(String s, String t) {
        String res = s;
        boolean updated = false;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int count = t.length();
        for (int i = 0; i < t.length(); i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            char cur = s.charAt(r);
            if (map.containsKey(cur)) {
                if (map.get(cur) > 0) {
                    count--;
                    map.put(cur, map.get(cur) - 1);
                    while (count == 0) {
                        if (s.substring(l, r + 1).length() <= res.length()) {
                            res = s.substring(l, r + 1);
                            updated = true;
                        }
                        char removed = s.charAt(l++);
                        if (map.containsKey(removed)) {
                            map.put(removed, map.get(removed) + 1);
                            if (map.get(removed) > 0) count++;
                        }
                    }
                } else {
                    map.put(cur, map.get(cur) - 1);
                }
            }
            r++;
        }
        return updated ? res : "";
    }
}
