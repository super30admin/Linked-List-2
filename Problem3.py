"""237. Delete Node in a Linked List
Time Complexity - O(1)
Space Complexity - O(1)
Copy next node value in node that needs to be deleted.
Point current_node.next = current_node.next.next"""

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
        