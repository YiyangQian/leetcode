#
# [5] Longest Palindromic Substring
#
# https://leetcode.com/problems/longest-palindromic-substring/description/
#
# algorithms
# Medium (25.53%)
# Total Accepted:    336.3K
# Total Submissions: 1.3M
# Testcase Example:  '"babad"'
#
# Given a string s, find the longest palindromic substring in s. You may assume
# that the maximum length of s is 1000.
# 
# Example 1:
# 
# 
# Input: "babad"
# Output: "bab"
# Note: "aba" is also a valid answer.
# 
# 
# Example 2:
# 
# 
# Input: "cbbd"
# Output: "bb"
# 
# 
#
class Solution:
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        track = 0
        res = ""
        for i in range(len(s)): 
            step1 = self.getStep(s, i, i)
            step2 = self.getStep(s, i, i + 1)
            length1 = 2 * step1 - 1
            length2 = 2 * step2
            if length1 > track: 
                track = length1 
                res = s[i - step1 + 1: i + step1]
            if length2 > track:
                track = length2
                res = s[i - step2 + 1: i + step2 + 1]
        return res

    def getStep(self, s, i, j): 
        step = 0
        if j == len(s):
            return 1
        while i > -1 and j < len(s) and s[i] == s[j]: 
            step = step + 1
            i = i - 1
            j = j + 1
        return step 
