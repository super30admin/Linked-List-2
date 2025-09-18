# Time Complexity : O(N) where N is the number of nodes in the linked list
# Space Complexity : O(1) as we only use a constant amount of extra space for pointers
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach:
# We will copy the value of the next node to the current node and delete the next node.
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
        del_node.data = del_node.next.data
        del_node.next = del_node.next.next
