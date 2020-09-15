#Time Complexity : O(1) where n is the number of elements
#Space Complexity : O(1)
#Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : 
#Your code here along with comments explaining your approach

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
        node.val=node.next.val
        node.next=node.next.next