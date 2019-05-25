/*
 * [564] Find the Closest Palindrome
 *
 * https://leetcode.com/problems/find-the-closest-palindrome/description/
 *
 * algorithms
 * Hard (18.67%)
 * Total Accepted:    13.6K
 * Total Submissions: 72.7K
 * Testcase Example:  '"1"'
 *
 * Given an integer n, find the closest integer (not including itself), which
 * is a palindrome. 
 * 
 * The 'closest' is defined as absolute difference minimized between two
 * integers.
 * 
 * Example 1:
 * 
 * Input: "123"
 * Output: "121"
 * 
 * 
 * 
 * Note:
 * 
 * The input n is a positive integer represented by string, whose length will
 * not exceed 18.
 * If there is a tie, return the smaller one as answer.
 * 
 * 
 */
class Solution {
    public String nearestPalindromic(String n) {
        // 12345
        long left = Long.parseLong(n.substring(0, (n.length() + 1) / 2));
        List<Long> candidates = new ArrayList<>();
        candidates.add(concat(left, n.length() % 2 == 0));       // 12321
        candidates.add(concat(left + 1, n.length() % 2 == 0));   // 12421
        candidates.add(concat(left - 1, n.length() % 2 == 0));   // 12221
        candidates.add((long) Math.pow(10, n.length() - 1) - 1); //  9999
        candidates.add((long) Math.pow(10, n.length()) + 1);     //100001

        long track = Long.MAX_VALUE;
        long res = 0;
        long cur = Long.valueOf(n);
        for (Long candidate : candidates) {
            System.out.print(" " + candidate);
            if (candidate == cur) continue;
            if (Math.abs(candidate - cur) < track) {
                track = Math.abs(candidate - cur);
                res = candidate;
            } else if (Math.abs(candidate - cur) == track) {
                res = Math.min(res, candidate);
            }
        }
        return String.valueOf(res);
    }

    public Long concat(long left, boolean isEven) {
        long res = left;
        if (!isEven) left = left / 10;
        while (left != 0) {
            res = res * 10 + left % 10;
            left = left / 10;
        }
        return res;
    }
}


// 100 101
// 99 101

// 121 111

// 1283 1331

// 1222 1221