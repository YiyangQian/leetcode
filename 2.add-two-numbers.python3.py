#
# [2] Add Two Numbers
#
# https://leetcode.com/problems/add-two-numbers/description/
#
# algorithms
# Medium (28.90%)
# Total Accepted:    527.2K
# Total Submissions: 1.8M
# Testcase Example:  '[2,4,3]\n[5,6,4]'
#
# You are given two non-empty linked lists representing two non-negative
# integers. The digits are stored in reverse order and each of their nodes
# contain a single digit. Add the two numbers and return it as a linked list.
# 
    # You may assume the two numbers do not contain any leading zero, except the
# number 0 itself.
# 
# 
# Example
# 
# Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)                      2 4   5  6 4 
# Output: 7 -> 0 -> 8                                        42  465 
# Explanation: 342 + 465 = 807.
# 
# 
#
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
        pointer1 = l1 
        pointer2 = l2 
        result_dummy = ListNode(0)
        res_pointer = result_dummy
        carrier = 0
        while(pointer1 or pointer2): 
            if pointer1: 
                value1 = pointer1.val
                pointer1 = pointer1.next
            else: 
                value1 = 0 
            if pointer2: 
                value2 = pointer2.val
                pointer2 = pointer2.next
            else: 
                value2 = 0
                
            sum = value1 + value2 + carrier 
            remainder = sum % 10 
            carrier = sum // 10 

            res_pointer.next = ListNode(remainder)
            res_pointer = res_pointer.next
        if carrier is not 0: 
            res_pointer.next = ListNode(carrier)
        return result_dummy.next

