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

''' 
Time Complexity: O(1) 
Space Complexity: O(1)

Approach:
Since we are not given the head of the linked list, we cannot traverse the list to find the previous node. 
So, instead of actually deleting the node, we can copy the data from the next node into the current node and then delete the next node. 


'''
class Solution:
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        if node.next:
            node.data = node.next.data 
            node.next = node.next.next