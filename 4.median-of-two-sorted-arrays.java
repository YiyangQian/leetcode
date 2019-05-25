/*
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (26.31%)
 * Total Accepted:    433.5K
 * Total Submissions: 1.6M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * 
 * Example 2:
 * 
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 * 
 */
// A[1] A[2] .... A[i - 1] | A[i] .... A[m]
// B[1] B[2] .... B[j - 1] | B[j] .... B[n]
// m <= n 
// binary search i
// j = (n + m + 1) / 2 - i       if we have odd num, left part has one more element
// A[i - 1] <= B[j] and B[j - 1] <= A[i]

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1.length <= nums2.length ? nums1 : nums2;
        int[] B = nums1.length <= nums2.length ? nums2 : nums1;
        int m = A.length, n = B.length;
        int l = 0, r = m;
        int i, j;
        double res = 0;
        while (l <= r) {
            i = (l + r) / 2;
            j = (m + n + 1) / 2 - i;
            if (i > 0 && A[i - 1] > B[j]) {
                r = i - 1;
            } else if (i < m && B[j - 1] > A[i]) {
                l = i + 1;
            } else {
                int maxOfLeft, minOfRight;
                if (i == 0) {
                    maxOfLeft = B[j - 1];
                } else if (j == 0) {
                    maxOfLeft = A[i - 1];
                } else {
                    maxOfLeft = Math.max(A[i - 1], B[j - 1]);
                }

                if ((m + n) % 2 == 1) return maxOfLeft;

                if (i == m) {
                    minOfRight = B[j];
                } else if (j == n) {
                    minOfRight = A[i];
                } else {
                    minOfRight = Math.min(A[i], B[j]);
                }

                return res = (maxOfLeft + minOfRight) / 2.0;
            }
        }
        return res;
    }
}
