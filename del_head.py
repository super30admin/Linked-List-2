# The code defines a deleteNode method to delete a given node from a singly linked list.
# Note: The method is designed to work only when the node to be deleted is not the tail of the list.

# Approach:
#   - The method does not directly delete the node itself; instead, it copies the data and pointer of the next node into the current node.
#   - This effectively bypasses the current node by overwriting it with the next node's data and link.

# Steps:
#   - If the given node or its next node is None, return None, as deletion is not possible (invalid input or node is the tail).
#   - Update the value of the current node (node.data) with the value of the next node (node.next.data).
#   - Update the next pointer of the current node (node.next) to skip the next node by pointing to node.next.next.
#       - This effectively removes the next node from the list.

# Final Result:
#   - The given node now contains the value and link of its next node, and the list is adjusted to remove the original next node.

# TC: O(1) - The operation is constant time, as it involves only a few pointer updates.
# SC: O(1) - The space complexity is constant, as no additional data structures are used.


class Solution:

    def deleteNode(self, node):

        if not node or not node.next:
            return None   

        node.data = node.next.data      
        node.next = node.next.next      