# // Time Complexity :O(N)
# // Space Complexity :o(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no


# // Your code here along with comments explaining your approach
# as we dont have head pointer and we have pointer of node thats need to be detaled best way would copy next node data in curr node, be carefull regarding last node

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
    # Function to delete a node in the middle of a singly linked list.
    def deleteNode(self, node):
        #code here
        while( node.next.next is not None):
            node.data=node.next.data
            node=node.next
        node.data=node.next.data
        node.next=None
