#
# [7] Reverse Integer
#
# https://leetcode.com/problems/reverse-integer/description/
#
# algorithms
# Easy (24.38%)
# Total Accepted:    433.5K
# Total Submissions: 1.8M
# Testcase Example:  '123'
#
# Given a 32-bit signed integer, reverse digits of an integer.
# 
# Example 1:
# 
# 
# Input: 123
# Output: 321
# 
# 
# Example 2:
# 
# 
# Input: -123
# Output: -321
# 
# 
# Example 3:
# 
# 
# Input: 120
# Output: 21
# 
# 
# Note:
# Assume we are dealing with an environment which could only store integers
# within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of
# this problem, assume that your function returns 0 when the reversed integer
# overflows.
# 
#
class Solution:
    def reverse(self, x):
        """
        :type x: int
        :rtype: int
        """
        isNegative = False
        tempt = str(x)
        if x < 0:
            isNegative = True
            tempt = tempt[1:]
        # It works by doing [begin:end:step] - by leaving begin and end off and specifying a step of -1, it reverses a string.
        res = tempt[::-1]
        res = int(res)
        if isNegative:
            res =  0 - res
        if res < -pow(2, 31) or res > pow(2, 31) - 1: 
            return 0 
        return res

        
