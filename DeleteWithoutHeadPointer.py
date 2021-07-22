# Time Complexity : O(n)
# Space Complexity : O(1)

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
    def deleteNode(self,curr_node):
        #code here
        curr = curr_node
        prev = None 

        while curr.next:
            curr.data = curr.next.data 
            prev = curr 
            curr = curr.next

        prev.next = None 