// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
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
    if curr_node.next:    //check if curr is the not the last element in the list 
        curr_node.data=curr_node.next.data    //copey the data from next node to the current node
        curr_node.next=curr_node.next.next    //delete the next node by pointing the next of current to the next of next
    else:
        curr=None //if ucrrent is last element of the list simply make it null
