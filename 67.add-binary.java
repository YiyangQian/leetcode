/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (38.44%)
 * Total Accepted:    287.7K
 * Total Submissions: 748.2K
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings, return their sum (also a binary string).
 * 
 * The input strings are both non-empty and contains only characters 1 or 0.
 * 
 * Example 1:
 * 
 * 
 * Input: a = "11", b = "1"
 * Output: "100"
 * 
 * Example 2:
 * 
 * 
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 */
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int p = a.length() - 1, q = b.length() - 1;
        int carryOn = 0;
        while (p != -1  || q != -1) {
            int sum = 0;
            if (p != -1) {
                sum += a.charAt(p) - '0';
                p--;
            }
            if (q != -1) {
                sum += b.charAt(q) - '0';
                q--;
            }
            sum += carryOn;
            if (sum == 0) {
                sb.insert(0, '0');
                carryOn = 0;
            } else if (sum == 1) {
                sb.insert(0, '1');
                carryOn = 0;
            } else if (sum == 2) {
                sb.insert(0, '0');
                carryOn = 1;
            } else {
                sb.insert(0, '1');
                carryOn = 1;
            }
        }
        if (carryOn != 0) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
