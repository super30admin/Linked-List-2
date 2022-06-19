"""Approach:
Since we can't find previous node we can just copy value of next node to 
current node, and when next node.next is None, make curr node.next = None.
effectively deleting last node, and overwriting other node values
TC O(n) if we are deleting head node of linked list of len n without knowing.
SC O(1)"""
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
        # Since we can't find previous node we can just copy value of next node to 
        # current node, and when next node.next is None, make curr node.next = None.
        # effectively deleting last node, and overwriting other node values
        if curr_node.next:
            p1 = curr_node
            p2 = curr_node.next
            p1.data = p2.data
        while p2.next:
            p1 = p1.next
            p2 = p2.next
            p1.data = p2.data
        p1.next = None
