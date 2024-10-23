# Approach:
# The function `deleteNode` deletes a node from the middle of a singly linked list, 
# given only access to that node (not the head of the list).
# 1. Instead of removing the node directly, we copy the value of the next node to the current node.
# 2. Then, we update the next pointer of the current node to skip over the next node, effectively deleting it.
# 
# Note: This solution only works if the node to be deleted is not the tail node.
# 
# Time Complexity:
# - O(1), as we perform constant-time operations (copying values and adjusting pointers).
# 
# Space Complexity:
# - O(1), as no additional space is used beyond a few variables for pointers.

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        # Copy the data from the next node to the current node
        node.data = node.next.data
        # Point the current node's next to the next node's next
        node.next = node.next.next
