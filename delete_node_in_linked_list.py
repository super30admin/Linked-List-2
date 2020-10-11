"""
Problem: 237. Delete Node in a Linked List
Leetcode: https://leetcode.com/problems/delete-node-in-a-linked-list/
Time Complexity: O(1)
Space Complexity: O(1)
"""


# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        # replace the value of given node with the value of next node
        node.val = node.next.val
        # Point the next node of current node to next of next so that
        # the next node which now has extra value of the current node will be deleted
        node.next = node.next.next