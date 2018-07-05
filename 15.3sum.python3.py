#
# [15] 3Sum
#
# https://leetcode.com/problems/3sum/description/
#
# algorithms
# Medium (21.84%)
# Total Accepted:    344.1K
# Total Submissions: 1.6M
# Testcase Example:  '[-1,0,1,2,-1,-4]'
#
# Given an array nums of n integers, are there elements a, b, c in nums such
# that a + b + c = 0? Find all unique triplets in the array which gives the sum
# of zero.
# 
# Note:
# 
# The solution set must not contain duplicate triplets.
# 
# Example:
# 
# 
# Given array nums = [-1, 0, 1, 2, -1, -4], -4 -1 0 1 2
# 
# A solution set is:
# [
# ⁠ [-1, 0, 1],
# ⁠ [-1, -1, 2]
# ]
# 
# 
#
class Solution:
    def threeSum(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums, key=int, reverse=False)
        res = []
        for i in range(len(nums)):
            if i != 0 and nums[i] == nums[i - 1]: 
                continue
            target = 0 - nums[i]
            matchedTwoNum = self.getMatchTwo(nums, target, i + 1)
            for pair in matchedTwoNum:
                res.append([nums[i]] + pair)
        return res

    def getMatchTwo(self, nums, target, l):
        lpointer = l
        rpointer = len(nums) - 1
        pairs = []
        while lpointer < rpointer:
            sum = nums[lpointer] + nums[rpointer]
            if sum == target: 
                pairs.append([nums[lpointer], nums[rpointer]])
                while lpointer + 1 < len(nums) and nums[lpointer] == nums[lpointer + 1]:
                    lpointer = lpointer + 1
                while rpointer > 0 and nums[rpointer] == nums[rpointer - 1]:
                    rpointer = rpointer - 1
                lpointer = lpointer + 1
            elif sum < target:
                lpointer = lpointer + 1
            else: 
                rpointer = rpointer - 1
        return pairs

s = Solution()
print(s.threeSum([-1,0,1,2,-1,-4]))
# print(s.getMatchTwo([-3, -1, -1, 1, 2, 4], 3, 1))

