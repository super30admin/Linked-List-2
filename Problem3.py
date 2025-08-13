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


        #O(N)😂 thought this is the best possible earlier
        # t = None
        # while node.next:
        #         node.val = node.next.val
        #         t = node
        #         node = node.next
        
        # t.next = None
        
