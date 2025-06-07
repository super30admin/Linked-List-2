"""
I first stored the next node in a temporary variable, then updated the current node's data with the data of the temporary node. Finally, I disconnected the temporary node by updating the current node's next pointer.
Time Complexity: O(1)
Space Complexity: O(1)
"""
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
        tempNode = node.next
        node.data = tempNode.data
        node.next = tempNode.next
        tempNode.next = None