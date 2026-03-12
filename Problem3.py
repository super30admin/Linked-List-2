#Delete without head pointer

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

# Time -> On
# Space -> O1
# Logic -> Move values to 1 node before, and once you are at 2nd last node, frop the last node

class Solution:
    def deleteNode(self, del_node):
        # code here
        del_node.data = del_node.next.data

        if del_node.next != None:
            if del_node.next.next != None:
                del_node=del_node.next
                self.deleteNode(del_node)
            else:
                del_node.next=None