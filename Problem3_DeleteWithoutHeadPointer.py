# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Approach: Copy the value of next node to current node, then delete the next node.
# Since we can't access the previous node, we simulate deletion by copying next node's data and removing next node.

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
        # Copy the value from next node
        node.val = node.next.val
        # Delete the next node by pointing to next.next
        node.next = node.next.next
