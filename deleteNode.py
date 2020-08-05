# Delete Nodes from a list without a head pointer

# Time Complexity :  O(n) is the number of nodes

# Space Complexity : O(1)

# Any problem you faced while coding this : No

# Approach: Change the value of the node with next node's value. Change the next pointer of the node 
# with next pointer of the subsequent node.

# Your code here along with comments explaining your approach

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

def deleteNode(node):
    # Changing the value of the node with next node's value
    node.val = node.next.val
    # Changing the next pointer of the node
    node.next = node.next.next