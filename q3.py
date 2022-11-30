# Time Complexity : O(1)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing Specific

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
        #In this approach we are not deleting the exact node itself, but we are tryinh to rearrange the nodes as per our needs
        temp=node
        temp1=node.next
        #Here we are modifying the val and next as per needs
        node.val=temp1.val
        node.next=temp1.next
        #Here we deleting the unnecessary nodes in the linked list since it is having duplicates 
        del temp1