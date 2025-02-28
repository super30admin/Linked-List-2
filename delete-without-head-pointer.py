# The code deletes a given node (except the last one) in a singly linked list by copying the next node’s value into it and 
# updating its next pointer to skip the next node.

# Time Complexity: O(1) (Only modifies one node).
# Space Complexity: O(1) (No extra memory used).

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        # Checking if node is valid and not the last node.
        if node is None or node.next is None:
            return
        # Storing the next node in a variable.
        next_node = node.next
        # Copying data of the next node to the current node.
        node.data = next_node.data
        # Updating the next of the current node to the next of the next node.
        node.next = next_node.next