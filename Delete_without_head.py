"""
The idea is to delete value from the LL not the node itself. So swap values till the end of the list.
TC: O(n)
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

        curr = node.next
        prev = node
        while curr.next:
            prev.val = curr.val
            prev = curr
            curr = curr.next

        prev.val = curr.val
        prev.next = None
