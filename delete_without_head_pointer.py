# Time complexity - O(n)
# Space complexity - O(1)

# Approach - 

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

def deleteNode(self, node):
        if not node or node.next is None: 
            return
        temp = node.next
        node.data = node.next.data
        node.next = temp.next
        del temp