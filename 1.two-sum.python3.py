#
# [1] Two Sum
#
# https://leetcode.com/problems/two-sum/description/
#
# algorithms
# Easy (38.46%)
# Total Accepted:    970.5K
# Total Submissions: 2.5M
# Testcase Example:  '[2,7,11,15]\n9'
#
# Given an array of integers, return indices of the two numbers such that they
# add up to a specific target.
# 
# You may assume that each input would have exactly one solution, and you may
# not use the same element twice.
# 
# Example:
# 
# 
# Given nums = [2, 7, 11, 15], target = 9,
# 
# Because nums[0] + nums[1] = 2 + 7 = 9,
# return [0, 1].
# 
# 
# 
# 
#
class Solution:
    def twoSum(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        dict = {}
        result = []
#         key is the value and value is index 
        for i in range(len(nums)): 
            if target - nums[i] in dict.keys(): 
                result.append(dict[target - nums[i]])
                result.append(i) 
                return result
            else: 
                dict[nums[i]] = i
        return result        
