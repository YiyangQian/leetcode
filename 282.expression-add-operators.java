/*
 * @lc app=leetcode id=282 lang=java
 *
 * [282] Expression Add Operators
 *
 * https://leetcode.com/problems/expression-add-operators/description/
 *
 * algorithms
 * Hard (32.49%)
 * Total Accepted:    65.7K
 * Total Submissions: 202K
 * Testcase Example:  '"123"\n6'
 *
 * Given a string that contains only digits 0-9 and a target value, return all
 * possibilities to add binary operators (not unary) +, -, or * between the
 * digits so they evaluate to the target value.
 * 
 * Example 1:
 * 
 * 
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"] 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * 
 * Example 3:
 * 
 * 
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * 
 * Example 4:
 * 
 * 
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * 
 * 
 * Example 5:
 * 
 * 
 * Input: num = "3456237490", target = 9191
 * Output: []
 * 
 * 
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res =  new ArrayList<String>();
        if (num.length() == 0) return res;
        helper(num, target, res, "", 0, 0, 1);
        return res;
    }

    public void helper(String num, int target, List<String> res, String cur, long pre, int p, long mult) {
        if (p == num.length()) {
            if (pre == target) res.add(cur);
            return;
        }
        for (int i = p; i < num.length(); i++) {
            if (i != p && num.charAt(p) == '0') break;
            long curNum = Long.parseLong(num.substring(p, i + 1));
            if (p == 0) {
                helper(num, target, res, cur + curNum, curNum, i + 1, curNum);
            } else {
                helper(num, target, res, cur + "+" + curNum, pre + curNum, i + 1, curNum);
                helper(num, target, res, cur + "-" + curNum, pre - curNum, i + 1, -curNum);
                helper(num, target, res, cur + "*" + curNum, pre - mult + mult * curNum, i + 1, mult * curNum);
            }
        }
    }
}
