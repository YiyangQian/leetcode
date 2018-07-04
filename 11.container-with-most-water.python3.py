#
# [11] Container With Most Water
#
# https://leetcode.com/problems/container-with-most-water/description/
#
# algorithms
# Medium (37.28%)
# Total Accepted:    211.4K
# Total Submissions: 567K
# Testcase Example:  '[1,1]'
#
# Given n non-negative integers a1, a2, ..., an, where each represents a point
# at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
# of line i is at (i, ai) and (i, 0). Find two lines, which together with
# x-axis forms a container, such that the container contains the most water.
# 
# Note: You may not slant the container and n is at least 2.
# int
#

 
class Solution:
    def maxArea(self, height):
        """
        :type height: List[int]
        :rtype: 
        """
        lpointer = 0
        rpointer = len(height) - 1
        maxContainer = 0
        while lpointer  < rpointer: 
            currentMax = min(height[lpointer], height[rpointer]) * (rpointer - lpointer)
            maxContainer = max(currentMax, maxContainer)
            if height[lpointer] < height[rpointer]:
                lpointer = lpointer + 1
            else: 
                rpointer = rpointer - 1
        return maxContainer

# solution = Solution()
# print(solution.maxArea([12,2,4]))
        