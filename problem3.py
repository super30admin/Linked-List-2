# https://www.geeksforgeeks.org/problems/delete-without-head-pointer/1

# Time Complexity : O(N) where N is number of nodes
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None


# Your code here along with comments explaining your approach

# Approach : We keep copying all the next node values to cur node value and keep moving the cur pointer till the
# penultimate end. After that we make cur.next as None.

# User function Template for python3
#     Your task is to delete the given node from
# 	the linked list, without using head pointer.
#
# 	Function Arguments: node (given node to be deleted)
# 	Return Type: None, just delete the given node from the linked list.
#
# 	{
# 		# Node Class
# 		class Node:
# 		    def __init__(self, data):   # data -> value stored in node
# 		        self.data = data
# 		        self.next = None
# 	}


class Solution:
    # Function to delete a node without any reference to head pointer.
    def deleteNode(self, curr_node):
        # code here
        prev = curr_node
        while curr_node.next is not None:
            next_node = curr_node.next
            curr_node.data = next_node.data
            prev = curr_node
            curr_node = next_node
        prev.next = None
