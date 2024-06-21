# Time O(1)
# Space O(1)

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
    #Function to delete a node without any reference to head pointer.
    def deleteNode(self,del_node):
        #code here
        if del_node is None or del_node.next is None:
            return None
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next
