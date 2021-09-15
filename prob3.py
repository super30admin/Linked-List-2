# Time Complexity : O(1) as we have the reference of the node to be deleted
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Your code here along with comments explaining your approach: 

# you have the reference of the node to be deleted, say x, 
# do x.val = x.next.val, change the data of x to the data of x.next
# then just change the next node reference of x to x.next.next
# so x.next = x.next.next
# doing this deletes the required node



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
        
        curr_node.data = curr_node.next.data
        curr_node.next = curr_node.next.next