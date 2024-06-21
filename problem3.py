'''
## Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)

Time Complexity : O(1)
Space Complexity : O(1)
Did this code successfully run on Geeks for Geeks : Yes
Any problem you faced while coding this: No

'''

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
  def deleteNode(self, del_node):

    # copy the value of the next node in del_node and delete the next node
    nextNode = del_node.next
    nextVal = nextNode.data
    del_node.data = nextVal
    del_node.next = del_node.next.next
