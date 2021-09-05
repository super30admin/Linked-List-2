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

"""
TC: O(sum of number of elements from the current node till the end of the list)
SC: O(1)
"""
class Solution:
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,curr_node):
        #code here
        if curr_node == None:
            return
        
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next