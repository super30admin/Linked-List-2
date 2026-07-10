# PROBLEM DELETE WITHOUT HEAD POINTER
# TIME COMPLEXTIY: O(1) as we are not traversing the given linked list
# SPACE COMPLEXITY: O(1) as we are only using pointer to solve the given problem

''' Structure of linked list Node
	{
		class Node:
		    def __init__(self, data):  
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    def deleteNode(self, del_node):
        # code here
        if del_node is None or del_node.next is None:
            return 
            
        next_node=del_node.next
        del_node.data=next_node.data
        del_node.next=next_node.next
        
        