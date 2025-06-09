
    # Your task is to delete the given node from
	# the linked list, without using head pointer.
	
	# Function Arguments: node (given node to be deleted) 
	# Return Type: None, just delete the given node from the linked list.

	# {
	# 	# Node Class
	# 	class Node:
	# 	    def __init__(self, data):   # data -> value stored in node
	# 	        self.data = data
	# 	        self.next = None
	# }

# Space Complexity - o(1)
# Time Complexity - o(1)

class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        temp = node.next
        node.data = temp.data
        node.next = temp.next
        temp.next = None