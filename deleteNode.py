
"""
Problem: Delete Node
Approach: delete the node given by assigning the next nodes value to curr node and deleting the next node
t.c. => O(1)
s.c. => O(1)
"""
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None
def deleteNode(node):
    node.val = node.next.val
    node.next = node.next.next