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
        dummy_node=ListNode(None)
        if node.next==None:
            node.next=dummy_node
            node.val=dummy_node.val
        else:
            node.val=node.next.val
            node.next=node.next.next
        
Time is O(1)
Space is O(1)
