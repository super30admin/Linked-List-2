"""
Approach: since you cannot delete the current node, delete the next node.

TC: O(1)
SC: O(1)
"""

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if curr_node.next:
            curr_node.data = curr_node.next.data
            curr_node.next = curr_node.next.next
        else:
            curr_node = None