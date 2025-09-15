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
    # to delete a node i need the prev node of the del node so that i can do del_node.prev = del_node.next 
    # and elimate this node. 
    # but the trick part is we don't have access to the prev node 
    # given del_node is not the last node
    # so i will copy the next of the del node to del node such the del is deleted 

    # tc : O(1)
    # sc : O(1)
    def deleteNode(self, del_node):
        # code here
        next_node = del_node.next # save the next of the del node 
        del_node.data = next_node.data # changed the del_node to del_node.next
        del_node.next = next_node.next # successsfully deleted the del next node 
        