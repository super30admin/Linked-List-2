# Delete without head pointer

#User function Template for python3
'''
    Your task is to delete the given node from
	the linked list, without using head pointer.
	
	Function Arguments: node (given node to be deleted) 
	Return Type: None, just delete the given node from the linked list.

	{
		# Node Class
		class Node:
		    def __init__(self, data):   # data -> value stored in node
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        if node is None or node.next is None:
            raise ValueError("Cannot delete the last node or a non-existent node with this method.")
        
        next_node = node.next

        while next_node.next != None:
            node.data = next_node.data
            node = node.next
            next_node = next_node.next
            # next_node.data = next_node.next.data
        if next_node.next is None:
            node.data = next_node.data
            node.next = None