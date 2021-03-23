#TimeComplexity:O(N) 
#SpaceComplexity: O(1)
#Did this code successfully run on Leetcode : Yes 
#Any problem you faced while coding this : No
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
    curr_node.data=curr_node.next.data
    curr_node.next=curr_node.next.next


