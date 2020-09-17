# problem link : https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1#_=_
# Time Complexity : O(1)
#  Space Complexity : O(1) 
#  Did this code successfully run on Leetcode : YEs on geeksforgeeks
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
'''
        Only option here is to copy the next element to the current element and reove the next element as we dont have head pointer of pointer to previous element
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

	Contributed By: Nagendra Jha
'''
def deleteNode(curr_node):
    #code here
    if curr_node.next == None:
        curr_node = None
        return
    curr_node.data = curr_node.next.data
    curr_node.next = curr_node.next.next