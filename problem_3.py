"""
problem 3: delete a node without head pointer
TC: O(1)
SC: O(1)
Approach: Copy the data of the next node to the current node and delete the next node.
"""

class Solution:
    # Function to delete a node in the middle of a singly linked list.

    def deleteNode(self, node):
        # code here
        if not node:
            return node

        node.data = node.next.data
        node.next = node.next.next


