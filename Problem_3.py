"""
Time Complexity : O(1) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
As we are not given head pointer and just pointer to node that we want to delete, we will just replace the 
value of the node with the one next to it and change its pointer. Although, the node reference would not 
be deleted, but the value will get deleted.

"""
# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None


class Solution(object):
    def deleteNode(self, node):
        """
        :type node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        node.val = node.next.val
        node.next = node.next.next
