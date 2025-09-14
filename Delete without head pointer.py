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
We just move/modify the values of nodes one step left starting from given
node to be deleted. The last Node in the list will then be deleted.
Time Complexity: O(N), traversing through the entire list
Space Complexity: O(1)
'''
class Solution:
    def deleteNode(self, del_node):
        # code here
        prev = None
        while del_node.next!=None:
            del_node.data = del_node.next.data
            prev = del_node
            del_node=del_node.next
        
        prev.next=None # remove the link to the last node in the list
        