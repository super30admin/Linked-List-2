# Problem3 (https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1)
# Time Complexity: O(1)
# Space Complexity: O(1)
# Approach: Can't unlink del_node since we have no access to the previous node. 
# Instead, overwrite del_node's value with the next node's value, then skip del_node.next over that next node entirely.
        
''' Structure of linked list Node
	{
		class Node:
		    def __init__(self, data):  
		        self.data = data
		        self.next = None
	}
'''
class Solution:
    def deleteNode(self, del_node):
        #nothing to delete if del_node doesn't exist, or if it's the last node 
        if del_node is None or del_node.next is None:
            return
        
        # Copy the next node's value into del_node, overwriting del_node's
        # original value 
        del_node.data = del_node.next.data

        # Bypass the next node entirely, del_node now points to whatever  the next node was pointing to, cutting the next node out of the
        # chain (it becomes unreachable and gets garbage collected)
        del_node.next = del_node.next.next