# problem 3 

# https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

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
    def deleteNode(self, del_node):
        # code here
        if del_node is None or del_node.next is None:
            return
        
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next