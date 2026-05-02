# O(1) time, O(1) space

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def deleteNode(self, del_node):
        """
        :type del_node: ListNode
        :rtype: void Do not return anything, modify node in-place instead.
        """
        # Since we don't have the head, we can't find the previous node.
        # Instead, we copy the value of the next node into the current node.
        del_node.val = del_node.next.val
        
        # Then, we bypass the next node by pointing to the one after it.
        # Effectively, the current node becomes the next node, and the 
        # original next node is removed from the chain.
        del_node.next = del_node.next.next