# Time Complexity: O(1)
# Space Complexity: O(1)

# We need to delete the node given, and we aren't given the reference to the head of the LinkedList.
# The problem specifies that all values in the LL are unique, and we need to decrease the number of nodes by 1.

# It is hard to traverse in the reverse direction to get the previous node of the current node, so instead, we can delete
# the next node and replace the current node's value by the next node's value.

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
        
        curr = node
        node.val = curr.next.val
        node.next = node.next.next
