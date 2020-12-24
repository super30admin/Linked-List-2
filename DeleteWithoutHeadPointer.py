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

# Approach: Here we are not given a head node. That means we can not traverse from start. 
# Whatever we need to do has to start from the node we are given. 
# So what we can do is replace the next node's value with current node's value and keep doing that until we reach end of the list.

# That means keep doing curr_node.data = curr_node.next.data

# Time comlexity: O(1)
# Space comlexity: O(1)
def deleteNode(curr_node):
    #code here

    if curr_node == None:
        return 
    
    prev = None
    
    while curr_node.next != None:
        curr_node.data = curr_node.next.data
        prev = curr_node
        curr_node = curr_node.next
        
    prev.next = None
