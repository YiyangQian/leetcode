/*
 * @lc app=leetcode id=689 lang=java
 *
 * [689] Maximum Sum of 3 Non-Overlapping Subarrays
 *
 * https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/description/
 *
 * algorithms
 * Hard (43.94%)
 * Total Accepted:    24.1K
 * Total Submissions: 54.9K
 * Testcase Example:  '[1,2,1,2,6,7,5,1]\n2'
 *
 * 
 * In a given array nums of positive integers, find three non-overlapping
 * subarrays with maximum sum.
 * 
 * 
 * Each subarray will be of size k, and we want to maximize the sum of all 3*k
 * entries.
 * 
 * 
 * Return the result as a list of indices representing the starting position of
 * each interval (0-indexed).  If there are multiple answers, return the
 * lexicographically smallest one.
 * 
 * Example:
 * 
 * Input: [1,2,1,2,6,7,5,1], 2
 * Output: [0, 3, 5]
 * Explanation: Subarrays [1, 2], [2, 6], [7, 5] correspond to the starting
 * indices [0, 3, 5].
 * We could have also taken [2, 1], but an answer of [1, 3, 5] would be
 * lexicographically larger.
 * 
 * 
 * 
 * Note:
 * nums.length will be between 1 and 20000.
 * nums[i] will be between 1 and 65535.
 * k will be between 1 and floor(nums.length / 3).
 * 
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int[] res = {-1, -1, -1};
        int[] W = new int[nums.length + 1 - k];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i - k >= 0) sum -= nums[i - k];
            if (i + 1 - k >= 0) W[i + 1 - k] = sum;
        }

        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }

        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] >= W[best]) best = i;
            right[i] = best;
        }

        int cur = 0;
        for (int j = k; j + k < W.length; j++) {
            int l = left[j - k], r = right[j + k];
            if (W[j] + W[l] + W[r] > cur) {
                cur = W[j] + W[l] + W[r];
                res[0] = l;
                res[1] = j;
                res[2] = r;
            }
        }
        return res;
    }
}
