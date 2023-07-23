# Time Complexity: O(1) 
# Space Complexity: O(1)
class Node:
	def __init__(self, data):   # data -> value stored in node
		self.data = data
		self.next = None

class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        if curr_node is None or curr_node.next is None:
            # If the node is None or the last node, we cannot delete it.
            return

        # Copy the data from the next node to the current node.
        curr_node.data = curr_node.next.data

        # Skip the next node by updating the next pointer of the current node.
        curr_node.next = curr_node.next.next