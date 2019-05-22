/*
 * @lc app=leetcode id=670 lang=java
 *
 * [670] Maximum Swap
 *
 * https://leetcode.com/problems/maximum-swap/description/
 *
 * algorithms
 * Medium (39.37%)
 * Total Accepted:    34.4K
 * Total Submissions: 87.3K
 * Testcase Example:  '2736'
 *
 * 
 * Given a non-negative integer, you could swap two digits at most once to get
 * the maximum valued number. Return the maximum valued number you could get.
 * 
 * 
 * Example 1:
 * 
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * The given number is in the range [0, 108]
 * 
 * 
 */
class Solution {
    public int maximumSwap(int num) {
        String snum = Integer.toString(num);
        int[] cur = new int[snum.length()];
        for (int i = 0; i < cur.length; i++) {
            cur[i] = snum.charAt(i) - '0';
        }
        int track = cur.length - 1;
        int[] maxAfterIndex = new int[cur.length];
        for (int i = cur.length - 1; i >= 0; i--) {
            if (cur[i] > cur[track]) {
                track = i;
            }
            maxAfterIndex[i] = track;
       }
       boolean flag = false;
       for (int i = 0; i < cur.length && flag == false; i++) {
           if (cur[i] != cur[maxAfterIndex[i]]) {
                int tempt = cur[i];
                cur[i] = cur[maxAfterIndex[i]];
                cur[maxAfterIndex[i]] = tempt;
                flag = true;
           }
       }
       int res = 0;
       for (int i = 0; i < cur.length; i++) {
           res = res * 10 + cur[i];
       }
       return res;
    }
}


// 0 1 2 3
// 2 7 3 6
// 1 1 3 3

// 0 1 2 3 4
// 9 8 3 6 8
// 0 4 4 4 4

// 1 9 9 3
// 1 1 2 3