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
Time Complexity : O(1) 
Space Complexity : O(1) 
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this :  No
'''
class Solution:
    def deleteNode(self, del_node):
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next