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
Space Complexity: O(1) -> Constant Space Complexity

Time Complexity: O(N) -> Linear iteration till the end of the list
"""

class Solution:
    def deleteNode(self, del_node):

        prev, curr, nn = None. del_node, del_node.next
        
        while nn!= None: 
            curr.data = nn.data
            prev = curr
            curr = curr.next
            nn = nn.next
            
        prev.next = None
