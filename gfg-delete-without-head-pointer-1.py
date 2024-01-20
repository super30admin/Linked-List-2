# https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1


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
 
 PROBLEM = #Function to delete a node without any reference to head pointer.
'''
class Solution:
    """
    Accepted
    Time Complexity : O(1)
    Space Complexity : O(1)
    
    Explanation:
        1. Copy the data from next node to current node
        2. Delete the next node like a regular deletion
    """
    def deleteNode(self,curr_node):
        #code here
        tmp = curr_node.next.next
        val = curr_node.next.data
        curr_node.data = val
        curr_node.next.next = None
        curr_node.next = tmp