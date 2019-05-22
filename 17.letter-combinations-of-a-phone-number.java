/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (40.91%)
 * Total Accepted:    365.6K
 * Total Submissions: 893.5K
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * 
 * Example:
 * 
 * 
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * 
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 */
class Solution {
    private final String[] dict = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) return res;
        char[] cur = new char[digits.length()];
        helper(digits, 0, cur, res);
        return res;
    }

    public void helper(String digits, int p, char[]cur, List<String> res) {
        if (p == digits.length()) {
            res.add(String.valueOf(cur));
            return;
        } 
        String mapped = dict[digits.charAt(p) - '0'];
        for (int i = 0; i < mapped.length(); i++) {
            cur[p] = mapped.charAt(i);
            helper(digits, p + 1, cur, res);
        }
    }
}
