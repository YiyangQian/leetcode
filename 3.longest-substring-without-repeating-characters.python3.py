#
# [3] Longest Substring Without Repeating Characters
#
# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
#
# algorithms
# Medium (24.81%)
# Total Accepted:    516.4K
# Total Submissions: 2.1M
# Testcase Example:  '"abcabcbb"'
#
# Given a string, find the length of the longest substring without repeating
# characters.
# 
# Examples:      
#       
# Given "abcabcbb", the answer is "abc", which the length is 3.
# 
# Given "bbbbb", the answer is "b", with the length of 1.
# 
# Given "pwwkew", the answer is "wke", with the length of 3. Note that the
# answer must be a substring, "pwke" is a subsequence and not a substring.
#
class Solution:
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        l = 0 
        r = 0 
        dict = {}
        track = 0 
        while r < len(s): 
            if s[r] not in dict.keys() or dict[s[r]] < l: 
                dict[s[r]] = r 
                track = max(r - l + 1, track) 
                r = r + 1 
            else: 
                l = dict[s[r]] + 1 
                dict[s[r]] = r
                track = max(r - l + 1, track) 
                r = r + 1 
        return track 
