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
        # TC - O(n) ?? not sure O(1) I guess as I am just copying next and changing pointer
        # Sc - O(1)
        node.val = node.next.val
        node.next = node.next.next
