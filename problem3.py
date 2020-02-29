'''
Iterative:
Time Complexity: O(1)
Space Complexity: O(1)
Did this code successfully run on Leetcode : Yes
Explanation : Copy the value of next element and delete the next element altogether
'''

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next