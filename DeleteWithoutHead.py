# Time Complexity: O(1) (Constant time)

# Space Complexity: O(1) (No extra space used)
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
        #code here
        # Copy the data from the next node to the current node
        del_node.data = del_node.next.data
        
        # Remove the next node
        del_node.next = del_node.next.next